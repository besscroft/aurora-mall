package com.besscroft.aurora.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 日志对象
 *
 * @Author Bess Croft
 * @Time 2021/7/18 17:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "日志对象")
public class WebLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", dataType = "String")
    private String id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;

    /** 日志描述信息 */
    @ApiModelProperty(value = "日志描述信息", dataType = "String")
    private String description;

    /** 请求地址 */
    @ApiModelProperty(value = "请求地址", dataType = "String")
    private String url;

    /** 请求方法 */
    @ApiModelProperty(value = "请求方法", dataType = "String")
    private String httpMethod;

    /** 请求方法路径:全限定名+方法名 */
    @ApiModelProperty(value = "请求方法路径:全限定名+方法名", dataType = "String")
    private String classMethod;

    /** 请求者ip地址 */
    @ApiModelProperty(value = "请求者ip地址", dataType = "String")
    private String ip;

    /** 请求入参 */
    @ApiModelProperty(value = "请求入参", dataType = "String")
    private String requestArgs;

    /** 响应出参 */
    @ApiModelProperty(value = "响应出参", dataType = "String")
    private String responseArgs;

    /** 请求时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "请求时间", dataType = "Date")
    private LocalDateTime startTime;

    /** 消耗时间(毫秒) */
    @ApiModelProperty(value = "消耗时间(毫秒)", dataType = "Date")
    private Long spendTime;

}
