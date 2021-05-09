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
 * 区域表对象
 *
 * @Author Besscroft
 * @Date 2021/4/26 16:40
 */
@TableName(value = "area")
@Document(indexName = "area")
@ApiModel(value = "区域表对象")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "区域id", dataType = "Integer")
    private Integer id;

    /** 区域名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "区域名称", dataType = "String")
    private String name;

    /** 区域代码 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "区域代码", dataType = "Integer")
    private Integer areaCode;

    /** 城市代码 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "城市代码", dataType = "Integer")
    private Integer cityCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("areaCode", getAreaCode())
                .append("cityCode", getCityCode())
                .toString();
    }

}
