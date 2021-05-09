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
 * 权限管理模块资源对象 bms_auth_resource
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:30
 */
@TableName(value = "bms_auth_resource")
@Document(indexName = "bms_auth_resource")
@ApiModel(value = "权限管理模块资源对象")
public class AuthResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "资源id", dataType = "Long")
    private Long id;

    /** 资源名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "资源名称", dataType = "String")
    private String name;

    /** 资源路径 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "资源路径", dataType = "String")
    private String url;

    /** 资源描述 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "资源描述", dataType = "String")
    private String description;

    /** 创建时间 */
    @Field(type = FieldType.Date)
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 资源类别ID */
    @Field(type = FieldType.Long)
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
