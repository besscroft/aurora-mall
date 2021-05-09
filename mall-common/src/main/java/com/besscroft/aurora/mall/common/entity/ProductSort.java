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
 * 商品管理模块商品分类对象 bms_product_sort
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:22
 */
@TableName(value = "bms_product_sort")
@Document(indexName = "bms_product_sort")
@ApiModel(value = "商品管理模块商品分类对象")
public class ProductSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品分类id", dataType = "Long")
    private Long id;

    /** 父id：0表示一级分类 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "父id", dataType = "Long")
    private Long parentId;

    /** 分类名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "分类名称", dataType = "String")
    private String name;

    /** 分类级别：0->1级；1->2级 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "分类级别", dataType = "Integer")
    private Integer level;

    /** 显示状态：0->不显示；1->显示 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "显示状态", dataType = "Integer")
    private Integer showStatus;

    /** 排序 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 图标 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "图标", dataType = "String")
    private String icon;

    /** 描述 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("parentId", getParentId())
                .append("name", getName())
                .append("level", getLevel())
                .append("showStatus", getShowStatus())
                .append("sort", getSort())
                .append("icon", getIcon())
                .append("description", getDescription())
                .toString();
    }

}
