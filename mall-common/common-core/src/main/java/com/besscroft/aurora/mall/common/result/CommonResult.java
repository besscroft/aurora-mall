package com.besscroft.aurora.mall.common.result;

import com.besscroft.aurora.mall.common.constant.HttpStatus;
import lombok.Data;

/**
 * 服务调用通用返回对象
 *
 * @Author Bess Croft
 *
 * @Date 2021/2/25 19:20
 */
@Data
public class CommonResult<T> {

    private int code;

    private String message;

    private T data;

    /**
     * 初始化一个新创建的 CommonResult 对象，使其表示一个空消息。
     */
    public CommonResult() {
    }

    /**
     * 初始化一个新创建的 CommonResult 对象
     * @param code
     * @param message
     * @param data
     */
    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 失败返回结果
     */
    public static CommonResult success() {
        return success("调用成功");
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(HttpStatus.SUCCESS, "调用成功", data);
    }

    /**
     * 成功返回结果
     *
     * @param message 提示信息
     */
    public static <T> CommonResult<T> success(String message) {
        return new CommonResult<T>(HttpStatus.SUCCESS, message, null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<T>(HttpStatus.SUCCESS, message, data);
    }

    /**
     * 失败返回结果
     */
    public static CommonResult failed() {
        return failed("调用失败");
    }

    /**
     * 失败返回结果
     * @param data
     * @return
     */
    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(HttpStatus.ERROR, "调用失败", data);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(HttpStatus.ERROR, message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message, T data) {
        return new CommonResult<T>(HttpStatus.ERROR, message, data);
    }

}
