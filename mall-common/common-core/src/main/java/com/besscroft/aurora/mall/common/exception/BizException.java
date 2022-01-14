package com.besscroft.aurora.mall.common.exception;

import com.besscroft.aurora.mall.common.result.IResultCode;
import lombok.Getter;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2022/1/9 15:18
 */
@Getter
public class BizException extends RuntimeException {

    public IResultCode resultCode;

    public BizException() {
        super("业务异常");
    }

    public BizException(String message){
        super(message);
    }

    public BizException(Throwable cause){
        super(cause);
    }

    public BizException(String message, Throwable cause){
        super(message, cause);
    }

    public BizException(IResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

}
