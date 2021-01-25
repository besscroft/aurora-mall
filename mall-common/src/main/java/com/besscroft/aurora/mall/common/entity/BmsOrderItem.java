package com.besscroft.aurora.mall.common.entity;

import com.besscroft.aurora.mall.common.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 订单管理模块订单子对象 bms_order_item
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:00
 */
public class BmsOrderItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 父订单id */
    private Long orderId;

    /** 订单编号 */
    private String orderSn;

    /** 商品id */
    private Long productId;

    /** 商品图片 */
    private String productPic;

    /** 商品名称 */
    private String productName;

    /** 商品品牌 */
    private String productBrand;

    /** 商品货号/编号 */
    private String productSn;

    /** 销售价格 */
    private BigDecimal productPrice;

    /** 购买数量 */
    private Long productQuantity;

    /** 商品套餐id */
    private Long productSkuId;

    /** 商品sku条码 */
    private String productSkuCode;

    /** 商品分类id */
    private Long productCategoryId;

    /** 极光券优惠分解金额 */
    private BigDecimal couponAmount;

    /** 该商品经过优惠后的分解金额 */
    private BigDecimal realAmount;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    private String productSkuAttr;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
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

