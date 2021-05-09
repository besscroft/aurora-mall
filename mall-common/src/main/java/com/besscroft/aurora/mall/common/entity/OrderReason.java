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
 * 订单管理模块订单售后原因对象 bms_order_reason
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:04
 */
@TableName(value = "bms_order_reason")
@Document(indexName = "bms_order_reason")
@ApiModel(value = "订单管理模块订单售后原因对象")
public class OrderReason implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单售后原因id", dataType = "Long")
    private Long id;

    /** 原因类型 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "原因类型", dataType = "String")
    private String name;

    /** 是否启用：0->不启用；1->启用 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "是否启用", dataType = "Integer")
    private Integer status;

    /** 创建时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private Date createTime;

    /** 排序 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 收货备注 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "收货备注", dataType = "String")
    private String receiveNote;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("sort", getSort())
                .append("receiveNote", getReceiveNote())
                .toString();
    }

}
