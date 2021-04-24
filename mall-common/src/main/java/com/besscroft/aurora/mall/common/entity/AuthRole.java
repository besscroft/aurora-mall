package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限管理模块角色对象 bms_auth_role
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:41
 */
@TableName(value = "bms_auth_role")
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 名称 */
    private String name;

    /** 描述 */
    private String description;

    /** 用户数量 */
    private Long adminCount;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 启用状态：0->禁用；1->启用 */
    private Integer status;

    /** 排序 */
    private Long sort;

    /** 假删除：0->删除状态；1->可用状态 */
    private Integer del;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(Long adminCount) {
        this.adminCount = adminCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("description", getDescription())
                .append("adminCount", getAdminCount())
                .append("createTime", getCreateTime())
                .append("status", getStatus())
                .append("sort", getSort())
                .append("del", getDel())
                .toString();
    }

}