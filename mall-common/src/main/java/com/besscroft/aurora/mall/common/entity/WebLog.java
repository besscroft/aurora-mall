package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志对象
 *
 * @Author Bess Croft
 * @Time 2021/7/18 17:15
 */
@Data
@TableName(value = "web_log")
@Document(indexName = "web_log")
@ApiModel(value = "日志对象")
public class WebLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "id", dataType = "Long")
    private String id;

    /** 用户名 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;

    /** 日志描述信息 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "日志描述信息", dataType = "String")
    private String description;

    /** 请求地址 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "请求地址", dataType = "String")
    private String url;

    /** 请求方法 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "请求方法", dataType = "String")
    private String httpMethod;

    /** 请求方法路径:全限定名+方法名 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "请求方法路径:全限定名+方法名", dataType = "String")
    private String classMethod;

    /** 请求者ip地址 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "请求者ip地址", dataType = "String")
    private String ip;

    /** 请求入参 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "请求入参", dataType = "String")
    private String requestArgs;

    /** 响应出参 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "响应出参", dataType = "String")
    private String responseArgs;

    /** 请求时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "请求时间", dataType = "Date")
    private Date startTime;

    /** 消耗时间(毫秒) */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "消耗时间(毫秒)", dataType = "Date")
    private Long spendTime;

}
