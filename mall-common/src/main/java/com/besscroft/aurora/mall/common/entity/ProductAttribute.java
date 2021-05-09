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
 * 商品管理模块商品类型属性对象 bms_product_attribute
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:15
 */
@TableName(value = "bms_product_attribute")
@Document(indexName = "bms_product_attribute")
@ApiModel(value = "商品管理模块商品类型属性对象")
public class ProductAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品类型属性id", dataType = "Long")
    private Long id;

    /** 属性名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "属性名称", dataType = "String")
    private String paramName;

    /** 父属性id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "父属性id", dataType = "Long")
    private Long paramId;

    /** 排序 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 属性值，以json格式保存 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "属性值", dataType = "String")
    private String value;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("paramName", getParamName())
                .append("paramId", getParamId())
                .append("sort", getSort())
                .append("value", getValue())
                .toString();
    }

}
