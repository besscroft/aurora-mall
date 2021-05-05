package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 城市表对象
 *
 * @Author Besscroft
 * @Date 2021/4/26 16:40
 */
@TableName(value = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /** 城市名称 */
    private String name;

    /** 城市代码 */
    private Integer cityCode;

    /** 省份代码 */
    private Integer provinceCode;

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

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("cityCode", getCityCode())
                .append("provinceCode", getProvinceCode())
                .toString();
    }

}
