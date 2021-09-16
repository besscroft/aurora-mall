package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 购物车模块购物车对象 ums_car
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:35
 */
@TableName(value = "ums_car")
@ApiModel(value = "购物车模块购物车对象")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "购物车id", dataType = "Long")
    private Long id;

    /** 购物车id */
    @ApiModelProperty(value = "购物车id", dataType = "String")
    private String carId;

    /** 用户id */
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("carId", getCarId())
                .append("userId", getUserId())
                .toString();
    }

}

