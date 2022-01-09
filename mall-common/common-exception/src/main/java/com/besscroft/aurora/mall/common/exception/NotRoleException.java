package com.besscroft.aurora.mall.common.exception;

import com.besscroft.aurora.mall.common.result.IResultCode;
import lombok.Getter;

/**
 * @Description 无角色异常
 * @Author Bess Croft
 * @Time 2022/1/9 15:11
 */
@Getter
public class NotRoleException extends RuntimeException {

    public IResultCode resultCode;

    public NotRoleException() {
        super("用户无角色");
    }

    public NotRoleException(String message){
        super(message);
    }

    public NotRoleException(Throwable cause){
        super(cause);
    }

    public NotRoleException(String message, Throwable cause){
        super(message, cause);
    }

    public NotRoleException(IResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

}
