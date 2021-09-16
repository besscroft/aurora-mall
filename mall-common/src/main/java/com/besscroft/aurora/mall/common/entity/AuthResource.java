package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 权限管理模块资源对象 bms_auth_resource
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:30
 */
@TableName(value = "bms_auth_resource")
@ApiModel(value = "权限管理模块资源对象")
public class AuthResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "资源id", dataType = "Long")
    private Long id;

    /** 资源名称 */
    @ApiModelProperty(value = "资源名称", dataType = "String")
    private String name;

    /** 资源路径 */
    @ApiModelProperty(value = "资源路径", dataType = "String")
    private String url;

    /** 资源描述 */
    @ApiModelProperty(value = "资源描述", dataType = "String")
    private String description;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate createTime;

    /** 资源类别ID */
    @ApiModelProperty(value = "资源类别ID", dataType = "Long")
    private Long categoryId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("url", getUrl())
                .append("description", getDescription())
                .append("createTime", getCreateTime())
                .append("categoryId", getCategoryId())
                .toString();
    }
}
