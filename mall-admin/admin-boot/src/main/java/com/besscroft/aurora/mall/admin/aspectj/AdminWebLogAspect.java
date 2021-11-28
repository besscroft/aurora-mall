package com.besscroft.aurora.mall.admin.aspectj;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.admin.api.LogFeignClient;
import com.besscroft.aurora.mall.common.runnable.MDCRunnable;
import com.besscroft.aurora.mall.common.aspectj.WebLogAspect;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 18:25
 */
@Component
public class AdminWebLogAspect extends WebLogAspect {

    private static final String KEY = "requestId";

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminWebLogAspect.class);

    /** 换行符 */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /** 用来记录请求进入的时间，防止多线程时出错，这里用了ThreadLocal */
    private ThreadLocal<Long> START_TIME = new ThreadLocal<>();

    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    @Resource
    private LogFeignClient logFeignClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 开始时间
        START_TIME.set(System.currentTimeMillis());
        // 执行切点
        Object result = proceedingJoinPoint.proceed();
        // 获取当前请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取header -> {"user_name":"admin","scope":["all"],"id":1,"exp":1629446968,"authorities":["1_?????"],"jti":"1e950613-593e-4112-b628-f36cbb346e16","client_id":"admin-app"}
        String header = request.getHeader(AuthConstants.USER_TOKEN_HEADER);
        LOGGER.info("header:{}", header);
        // 创建日志对象
        WebLog webLog = WebLog.builder().build();
        if(StrUtil.isNotBlank(header)){
            JsonNode jsonNode = objectMapper.readTree(header);
            LOGGER.info("userDto:{}", jsonNode);
            // 设置操作用户
            webLog.setUsername(StrUtil.sub(jsonNode.get("user_name").toString(), 1, -1));
        }
        // 设置id
        webLog.setId(IdUtil.simpleUUID());
        // 设置日志描述信息
        webLog.setDescription(super.getAspectLogDescription(proceedingJoinPoint));
        // 请求地址
        webLog.setUrl(request.getRequestURL().toString());
        // 请求方法
        webLog.setHttpMethod(request.getMethod());
        // 请求方法路径:全限定名+方法名
        webLog.setClassMethod(proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." +  proceedingJoinPoint.getSignature().getName() + "()");
        // 请求者ip地址
        webLog.setIp(request.getRemoteAddr());
        // 请求入参
        webLog.setRequestArgs(JSONUtil.toJsonStr(proceedingJoinPoint.getArgs()));
        // 响应出参
        webLog.setResponseArgs(JSONUtil.toJsonStr(result));
        // 请求时间
        webLog.setStartTime(LocalDateTime.now());
        // 消耗时间
        webLog.setSpendTime(System.currentTimeMillis() - START_TIME.get());
        // 打印响应参数
        LOGGER.info("Response Args:{}", JSONUtil.toJsonStr(result));
        // 执行时间
        LOGGER.info("Time Consuming:{}", System.currentTimeMillis() - START_TIME.get());
        try {
            // 异步线程池打印日志，用MDCRunnable装饰Runnable
            EXECUTOR.execute(new MDCRunnable(new Runnable() {
                @Override
                public void run() {
                    // 将日志信息存入数据库
                    logFeignClient.mallLog(webLog);
                }
            }));
            EXECUTOR.shutdown();
        } catch (Exception e) {
            LOGGER.error("调用 mall-log 服务失败！");
            e.printStackTrace();
        }
        // 出口移除请求ID
        MDC.remove(KEY);
        return result;
    }

    /**
     * 在切点之前织入
     * @param joinPoint
     */
    @Override
    public void deBefore(JoinPoint joinPoint) throws Exception {
        // 入口传入请求ID
        MDC.put(KEY, UUID.randomUUID().toString());
        // 获取当前请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 获取 @WebLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);

        // 打印请求相关参数
        LOGGER.info("================== Start ==================");
        // 打印请求 url
        LOGGER.info("URL            :{}", request.getRequestURL().toString());
        // 打印描述信息
        LOGGER.info("Description    :{}", methodDescription);
        // 打印 Http method
        LOGGER.info("HTTP Method    :{}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        LOGGER.info("Class Method   :{}.{}()", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        LOGGER.info("IP             :{}", request.getRemoteAddr());
        // 打印请求入参
        LOGGER.info("Request Args   :{}", JSONUtil.toJsonStr(joinPoint.getArgs()));
    }

    /**
     * 在切点之后织入
     */
    @Override
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("================== End ==================" + LINE_SEPARATOR);
    }

}
