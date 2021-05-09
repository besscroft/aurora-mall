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
 * 权限管理模块角色对象 bms_auth_role
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:41
 */
@TableName(value = "bms_auth_role")
@Document(indexName = "bms_auth_role")
@ApiModel(value = "权限管理模块角色对象")
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "角色id", dataType = "Long")
    private Long id;

    /** 名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "名称", dataType = "String")
    private String name;

    /** 描述 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;

    /** 用户数量 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "用户数量", dataType = "Long")
    private Long adminCount;

    /** 创建时间 */
    @Field(type = FieldType.Date)
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 启用状态：0->禁用；1->启用 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "启用状态", dataType = "Integer")
    private Integer status;

    /** 排序 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 假删除：0->删除状态；1->可用状态 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "假删除", dataType = "Integer")
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
