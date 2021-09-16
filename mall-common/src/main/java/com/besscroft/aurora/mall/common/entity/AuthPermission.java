package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限管理模块权限对象 bms_auth_permission
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:29
 */
@TableName(value = "bms_auth_permission")
@ApiModel(value = "权限管理模块权限对象")
public class AuthPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "权限id", dataType = "Long")
    private Long id;

    /** 父级权限id */
    @ApiModelProperty(value = "父级权限id", dataType = "Long")
    private Long pid;

    /** 名称 */
    @ApiModelProperty(value = "名称", dataType = "String")
    private String name;

    /** 权限值 */
    @ApiModelProperty(value = "权限值", dataType = "String")
    private String value;

    /** 图标 */
    @ApiModelProperty(value = "图标", dataType = "String")
    private String icon;

    /** 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限） */
    @ApiModelProperty(value = "父级ID", dataType = "Long")
    private Integer type;

    /** 前端资源路径 */
    @ApiModelProperty(value = "父级ID", dataType = "Long")
    private String uri;

    /** 启用状态；0->禁用；1->启用 */
    @ApiModelProperty(value = "启用状态", dataType = "Integer")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pid", getPid())
                .append("name", getName())
                .append("value", getValue())
                .append("icon", getIcon())
                .append("type", getType())
                .append("uri", getUri())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("sort", getSort())
                .toString();
    }

}
