package com.besscroft.aurora.mall.common.exception.handler;

import com.besscroft.aurora.mall.common.exception.BizException;
import com.besscroft.aurora.mall.common.exception.NotLoginException;
import com.besscroft.aurora.mall.common.exception.NotPermissionException;
import com.besscroft.aurora.mall.common.exception.NotRoleException;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.ServletException;
import javax.validation.ValidationException;
import java.util.concurrent.CompletionException;

/**
 * @Description 全局异常类
 * @Author Bess Croft
 * @Time 2022/1/9 14:54
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常拦截（拦截项目中的所有异常）
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) throws Exception {
        log.error("全局异常信息，异常原因:{}", e.getMessage(), e);
        return AjaxResult.error(e.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    public AjaxResult handlerNotLoginException(NotLoginException e) {
        log.error("未登录，请登录后再次访问，异常原因:{}", e.getMessage(), e);
        return AjaxResult.error("未登录，请登录后再次访问");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NotRoleException.class)
    public AjaxResult handlerNotRoleException(NotRoleException e) {
        log.error("拒绝授权异常信息，无此角色 role:{}，异常原因:{}", e.getResultCode().getRole(), e.getMessage(), e);
        return AjaxResult.error("拒绝授权异常信息，无此角色");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NotPermissionException.class)
    public AjaxResult handlerNotPermissionException(NotPermissionException e) {
        log.error("拒绝授权异常信息，无此权限 permission:{}，异常原因:{}", e.getResultCode().getPermission(), e.getMessage(), e);
        return AjaxResult.error("拒绝授权异常信息，无此权限");
    }

    /**
     * MethodArgumentTypeMismatchException
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public AjaxResult processException(MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), "类型错误");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public AjaxResult processException(ValidationException e) {
        log.error("参数校验失败，异常原因:{}", e.getMessage(), e);
        return AjaxResult.error("参数校验失败");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public AjaxResult handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("非法参数异常，异常原因:{}", e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonProcessingException.class)
    public AjaxResult handleJsonProcessingException(JsonProcessingException e) {
        log.error("Json转换异常，异常原因:{}", e.getMessage(), e);
        return AjaxResult.error(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CompletionException.class)
    public AjaxResult processException(CompletionException e) throws Exception {
        if (e.getMessage().startsWith("feign.FeignException")) {
            return AjaxResult.error("微服务调用异常");
        }
        return handleException(e);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BizException.class)
    public AjaxResult handleBizException(BizException e) {
        log.error("业务异常，异常原因:{}", e.getMessage(), e);
        if (e.getResultCode() != null) {
            return AjaxResult.error(e.getResultCode().getCode());
        }
        return AjaxResult.error(e.getMessage());
    }

}
