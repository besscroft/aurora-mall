package com.besscroft.aurora.mall.common.aspectj;

import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * web操作日志处理切面
 *
 * @Author Bess Croft
 * @Time 2021/7/18 17:23
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    /** 换行符 */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /** 用来记录请求进入的时间，防止多线程时出错，这里用了ThreadLocal */
    ThreadLocal<Long> START_TIME = new ThreadLocal<>();

    /** 配置织入点，以自定义 @webLog 注解为切点 */
    @Pointcut("@annotation(com.besscroft.aurora.mall.common.annotation.WebLog)")
    public void webLog() {

    }

    /**
     * 环绕方法
     * 执行切点后，会依次调用 @Before -> 接口逻辑代码 -> @After -> @AfterReturning
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 开始时间
        START_TIME.set(System.currentTimeMillis());
        // 执行切点
        Object result = proceedingJoinPoint.proceed();
        // 打印响应参数
        LOGGER.info("Response Args:{}", JSONUtil.toJsonStr(result));
        // 执行时间
        LOGGER.info("Time Consuming:{}", System.currentTimeMillis() - START_TIME.get());
        return result;
    }

    /**
     * 在切点之前织入
     * @param joinPoint
     */
    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Exception {
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
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("================== End ==================" + LINE_SEPARATOR);
    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }

}
