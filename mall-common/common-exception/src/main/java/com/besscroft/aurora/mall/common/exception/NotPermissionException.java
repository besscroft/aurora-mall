package com.besscroft.aurora.mall.common.exception;

import com.besscroft.aurora.mall.common.result.IResultCode;
import lombok.Getter;

/**
 * @Description 无权限异常
 * @Author Bess Croft
 * @Time 2022/1/9 15:15
 */
@Getter
public class NotPermissionException extends RuntimeException {

    public IResultCode resultCode;

    public NotPermissionException() {
        super("用户无权限");
    }

    public NotPermissionException(String message){
        super(message);
    }

    public NotPermissionException(Throwable cause){
        super(cause);
    }

    public NotPermissionException(String message, Throwable cause){
        super(message, cause);
    }

    public NotPermissionException(IResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

}
