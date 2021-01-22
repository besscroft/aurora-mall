package com.besscroft.aurora.mall.common.model.entity;

import com.besscroft.aurora.mall.common.model.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品管理模块商品类型属性对象 bms_product_attribute
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:15
 */
public class BmsProductAttribute extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 属性名称 */
    private String paramName;

    /** 父属性id */
    private Long paramId;

    /** 排序 */
    private Long sort;

    /** 属性值，以json格式保存 */
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
