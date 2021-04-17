package com.besscroft.aurora.mall.common.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 版本更新日志子表对象
 *
 * @Author Besscroft
 * @Date 2021/4/17 21:21
 */
public class BmsUpdateLogDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 更新日志id */
    private Long logId;

    /** 日志内容 */
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
