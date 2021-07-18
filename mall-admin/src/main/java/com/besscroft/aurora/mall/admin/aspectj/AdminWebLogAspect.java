package com.besscroft.aurora.mall.admin.aspectj;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.admin.service.LogService;
import com.besscroft.aurora.mall.common.aspectj.WebLogAspect;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.WebLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 18:25
 */
@Component
public class AdminWebLogAspect extends WebLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminWebLogAspect.class);

    /** 用来记录请求进入的时间，防止多线程时出错，这里用了ThreadLocal */
    private ThreadLocal<Long> START_TIME = new ThreadLocal<>();

    @Autowired
    private LogService logService;

    @Override
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 开始时间
        START_TIME.set(System.currentTimeMillis());
        // 执行切点
        Object result = proceedingJoinPoint.proceed();
        // 获取当前请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取header
        String header = request.getHeader(AuthConstants.USER_TOKEN_HEADER);
        // 创建日志对象
        WebLog webLog = new WebLog();
        if(StrUtil.isNotBlank(header)){
            UserDto userDto = JSONUtil.toBean(header, UserDto.class);
            // 设置操作用户
            webLog.setUsername(userDto.getUsername());
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
        webLog.setStartTime(new Date());
        // 消耗时间
        webLog.setSpendTime(System.currentTimeMillis() - START_TIME.get());
        // 打印响应参数
        LOGGER.info("Response Args:{}", JSONUtil.toJsonStr(result));
        // 执行时间
        LOGGER.info("Time Consuming:{}", System.currentTimeMillis() - START_TIME.get());
        // 将日志信息存入数据库
        logService.mallLog(webLog);
        return result;
    }
}
