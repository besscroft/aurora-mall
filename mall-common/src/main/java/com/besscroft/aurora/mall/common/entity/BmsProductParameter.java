package com.besscroft.aurora.mall.common.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 商品管理模块商品类型参数对象 bms_product_parameter
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:20
 */
public class BmsProductParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 参数名称 */
    private String paramName;

    /** 父参数id */
    private Long paramId;

    /** 排序 */
    private Long sort;

    /** 参数值，以json格式保存 */
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
