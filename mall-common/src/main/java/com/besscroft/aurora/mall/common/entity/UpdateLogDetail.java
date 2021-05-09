package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 版本更新日志子表对象
 *
 * @Author Besscroft
 * @Date 2021/4/17 21:21
 */
@TableName(value = "bms_update_log_detail")
@Document(indexName = "bms_update_log_detail")
@ApiModel(value = "版本更新日志子表对象")
public class UpdateLogDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "日志子id", dataType = "Long")
    private Long id;

    /** 更新日志id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "更新日志id", dataType = "Long")
    private Long logId;

    /** 日志内容 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "日志内容", dataType = "String")
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("logId", getLogId())
                .append("body", getBody())
                .toString();
    }

}
