package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单管理模块订单子对象 bms_order_item
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:00
 */
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductQuantity(Long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }
    public void setProductSkuAttr(String productSkuAttr) {
        this.productSkuAttr = productSkuAttr;
    }

    public String getProductSkuAttr() {
        return productSkuAttr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderId", getOrderId())
                .append("orderSn", getOrderSn())
                .append("productId", getProductId())
                .append("productPic", getProductPic())
                .append("productName", getProductName())
                .append("productBrand", getProductBrand())
                .append("productSn", getProductSn())
                .append("productPrice", getProductPrice())
                .append("productQuantity", getProductQuantity())
                .append("productSkuId", getProductSkuId())
                .append("productSkuCode", getProductSkuCode())
                .append("productCategoryId", getProductCategoryId())
                .append("couponAmount", getCouponAmount())
                .append("realAmount", getRealAmount())
                .append("productSkuAttr", getProductSkuAttr())
                .toString();
    }

}

