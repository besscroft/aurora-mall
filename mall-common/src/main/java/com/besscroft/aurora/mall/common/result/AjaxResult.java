package com.besscroft.aurora.mall.common.result;

import com.besscroft.aurora.mall.common.constant.HttpStatus;
import org.apache.commons.lang3.ObjectUtils;

import java.util.HashMap;

/**
 * Ajax封装对象
 *
 * @Author Besscroft
 * @Date 2021/1/23 13:58
 */
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "message";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param message 返回内容
     */
    public AjaxResult(int code, String message) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, message);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param message 返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String message, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, message);
        if (ObjectUtils.isNotEmpty(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success() {
        return AjaxResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AjaxResult success(Object data) {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param message 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String message) {
        return AjaxResult.success(message, null);
    }

    /**
     * 返回成功消息
     *
     * @param message 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String message, Object data) {
        return new AjaxResult(HttpStatus.SUCCESS, message, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static AjaxResult error() {
        return AjaxResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param message 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(String message) {
        return AjaxResult.error(message, null);
    }

    /**
     * 返回错误消息
     *
     * @param message 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String message, Object data) {
        return new AjaxResult(HttpStatus.ERROR, message, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param message 返回内容
     * @return 警告消息
     */
    public static AjaxResult error(int code, String message) {
        return new AjaxResult(code, message, null);
    }

}
