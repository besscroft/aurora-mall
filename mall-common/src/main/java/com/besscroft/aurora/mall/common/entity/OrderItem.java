package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单管理模块订单子对象 bms_order_item
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_order_item")
@ApiModel(value = "订单管理模块订单子对象")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单子id", dataType = "Long")
    private Long id;

    /** 父订单id */
    @ApiModelProperty(value = "父订单id", dataType = "String")
    private String orderId;

    /** 订单编号 */
    @ApiModelProperty(value = "订单编号", dataType = "String")
    private String orderSn;

    /** 商品id */
    @ApiModelProperty(value = "商品id", dataType = "Long")
    private Long productId;

    /** 商品图片 */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productPic;

    /** 商品名称 */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /** 商品品牌 */
    @ApiModelProperty(value = "商品品牌", dataType = "String")
    private String productBrand;

    /** 商品货号/编号 */
    @ApiModelProperty(value = "商品货号/编号", dataType = "String")
    private String productSn;

    /** 销售价格 */
    @ApiModelProperty(value = "销售价格", dataType = "BigDecimal")
    private BigDecimal productPrice;

    /** 购买数量 */
    @ApiModelProperty(value = "购买数量", dataType = "Long")
    private Long productQuantity;

    /** 商品套餐id */
    @ApiModelProperty(value = "商品套餐id", dataType = "Long")
    private Long productSkuId;

    /** 商品sku条码 */
    @ApiModelProperty(value = "商品sku条码", dataType = "String")
    private String productSkuCode;

    /** 商品分类id */
    @ApiModelProperty(value = "商品分类id", dataType = "Long")
    private Long productCategoryId;

    /** 极光券优惠分解金额 */
    @ApiModelProperty(value = "极光券优惠分解金额", dataType = "BigDecimal")
    private BigDecimal couponAmount;

    /** 该商品经过优惠后的分解金额 */
    @ApiModelProperty(value = "该商品经过优惠后的分解金额", dataType = "BigDecimal")
    private BigDecimal realAmount;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
    private String productSkuAttr;

}

