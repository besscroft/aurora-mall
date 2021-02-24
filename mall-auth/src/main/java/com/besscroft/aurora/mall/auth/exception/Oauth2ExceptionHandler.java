package com.besscroft.aurora.mall.auth.exception;

import com.besscroft.aurora.mall.common.result.AjaxResult;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Oauth2全局异常处理
 *
 * @Author Besscroft
 * @Date 2021/2/22 12:04
 */
@ControllerAdvice
public class Oauth2ExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = OAuth2Exception.class)
    public AjaxResult handleOauth2(OAuth2Exception e) {
        return AjaxResult.error(e.getMessage());
    }

}
