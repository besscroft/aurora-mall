package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 购物车模块购物车对象 ums_car
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:35
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}

