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

    /** 排序 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 属性选择类型：0->唯一；1->单选；2->多选 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "属性选择类型", dataType = "Integer")
    private Integer selectType;

    /** 属性录入方式：0->手工录入；1->从列表中选取 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "属性录入方式", dataType = "Integer")
    private Integer inputType;

    /** 分类筛选样式：1->普通；1->颜色 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "分类筛选样式", dataType = "Integer")
    private Integer filterType;

    /** 检索类型：0->不需要进行检索；1->关键字检索；2->范围检索 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "检索类型", dataType = "Integer")
    private Integer searchType;

    /** 相同属性产品是否关联：0->不关联；1->关联 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "相同属性产品是否关联", dataType = "Integer")
    private Integer relatedStatus;

    /** 是否支持手动新增：0->不支持；1->支持 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "是否支持手动新增", dataType = "Integer")
    private Integer handAddStatus;

    /** 属性的类型：0->规格；1->参数 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "属性的类型", dataType = "Integer")
    private Integer type;

    /** 属性值，以json格式保存 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "属性值", dataType = "String")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("paramName", getParamName())
                .append("sort", getSort())
                .append("selectType", getSelectType())
                .append("inputType", getInputType())
                .append("filterType", getFilterType())
                .append("searchType", getSearchType())
                .append("relatedStatus", getRelatedStatus())
                .append("handAddStatus", getHandAddStatus())
                .append("type", getType())
                .append("value", getValue())
                .toString();
    }

}
