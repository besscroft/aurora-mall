package com.besscroft.aurora.mall.common.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 商品管理模块商品类型对象 bms_product_type
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:24
 */
public class BmsProductType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 属性名称 */
    private String name;

    /** 属性数量，默认为0 */
    private Long attributeCount;

    /** 参数数量，默认为0 */
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
