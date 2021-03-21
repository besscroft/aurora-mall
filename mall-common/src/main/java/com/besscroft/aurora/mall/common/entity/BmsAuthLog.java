package com.besscroft.aurora.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限管理模块权限操作日志对象 bms_auth_log
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:24
 */
public class BmsAuthLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户名 */
    private String username;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date logTime;

    /** 操作详情，这里可以以json等格式保留信息 */
    private String logDetail;

    /** 操作者登录ip */
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
