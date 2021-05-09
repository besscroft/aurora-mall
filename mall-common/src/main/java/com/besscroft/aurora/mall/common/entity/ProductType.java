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
 * 商品管理模块商品类型对象 bms_product_type
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:24
 */
@TableName(value = "bms_product_type")
@Document(indexName = "bms_product_type")
@ApiModel(value = "商品管理模块商品类型对象")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品类型id", dataType = "Long")
    private Long id;

    /** 属性名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "属性名称", dataType = "String")
    private String name;

    /** 属性数量，默认为0 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "属性数量，默认为0", dataType = "Long")
    private Long attributeCount;

    /** 参数数量，默认为0 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "参数数量，默认为0", dataType = "Long")
    private Long paramCount;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAttributeCount(Long attributeCount) {
        this.attributeCount = attributeCount;
    }

    public Long getAttributeCount() {
        return attributeCount;
    }

    public void setParamCount(Long paramCount) {
        this.paramCount = paramCount;
    }

    public Long getParamCount() {
        return paramCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("attributeCount", getAttributeCount())
                .append("paramCount", getParamCount())
                .toString();
    }

}
