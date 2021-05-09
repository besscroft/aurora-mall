package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限管理模块权限操作日志对象 bms_auth_log
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:24
 */
@TableName(value = "bms_auth_log")
@Document(indexName = "bms_auth_log")
@ApiModel(value = "权限管理模块权限操作日志对象")
public class AuthLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Id
    @ApiModelProperty(value = "日志id", dataType = "Long")
    private Long id;

    /** 用户名 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;

    /** 操作时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "操作时间", dataType = "Date")
    private Date logTime;

    /** 操作详情，这里可以以json等格式保留信息 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "操作详情", dataType = "String")
    private String logDetail;

    /** 操作者登录ip */
    @Field(type = FieldType.Ip)
    @ApiModelProperty(value = "操作者登录ip", dataType = "String")
    private String logIp;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogDetail(String logDetail) {
        this.logDetail = logDetail;
    }

    public String getLogDetail() {
        return logDetail;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public String getLogIp() {
        return logIp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("logTime", getLogTime())
                .append("logDetail", getLogDetail())
                .append("logIp", getLogIp())
                .toString();
    }

}
