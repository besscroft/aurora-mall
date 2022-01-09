package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 购物车模块购物车子对象 ums_car_item
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ums_car_item")
@ApiModel(value = "购物车模块购物车子对象")
public class CarItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "购物车子id", dataType = "String")
    private String id;

    /** 购物车id */
    @ApiModelProperty(value = "购物车id", dataType = "String")
    private String cartId;

    /** 商品id */
    @ApiModelProperty(value = "商品id", dataType = "String")
    private String productId;

    /** 商品套餐id */
    @ApiModelProperty(value = "商品套餐id", dataType = "String")
    private String productSkuId;

    /** 用户id */
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long userId;

    /** 购买数量 */
    @ApiModelProperty(value = "购买数量", dataType = "Long")
    private Long quantity;

    /** 购物车商品价格 */
    @ApiModelProperty(value = "购物车商品价格", dataType = "BigDecimal")
    private BigDecimal price;

    /** 商品图片 */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productPic;

    /** 商品名称 */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /** 商品套餐编码 */
    @ApiModelProperty(value = "商品套餐编码", dataType = "String")
    private String productSkuCode;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createDate;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", dataType = "Date")
    private LocalDateTime modifyDate;

    /** 是否删除 */
    @ApiModelProperty(value = "是否删除", dataType = "Integer")
    private Integer deleteStatus;

    /** 商品编码 */
    @ApiModelProperty(value = "商品编码", dataType = "String")
    private String productSn;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
    private String productAttr;

}

