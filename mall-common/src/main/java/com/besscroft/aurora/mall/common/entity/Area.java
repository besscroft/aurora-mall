package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 区域表对象
 *
 * @Author Besscroft
 * @Date 2021/4/26 16:40
 */
@TableName(value = "area")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /** 区域名称 */
    private String name;

    /** 区域代码 */
    private Integer areaCode;

    /** 城市代码 */
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
