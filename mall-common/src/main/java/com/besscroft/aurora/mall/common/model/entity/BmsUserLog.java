package com.besscroft.aurora.mall.common.model.entity;

import com.besscroft.aurora.mall.common.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 会员管理模块会员用户操作日志对象 bms_user_log
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:33
 */
public class BmsUserLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
