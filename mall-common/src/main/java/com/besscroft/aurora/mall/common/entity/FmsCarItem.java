package com.besscroft.aurora.mall.common.entity;

import com.besscroft.aurora.mall.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车模块购物车子对象 fms_car_item
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:36
 */
public class FmsCarItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 商品id */
    private Long cartId;

    /** 商品id */
    private Long productId;

    /** 商品套餐id */
    private Long productSkuId;

    /** 用户id */
    private Long userId;

    /** 购买数量 */
    private Long quantity;

    /** 购物车商品价格 */
    private BigDecimal price;

    /** 商品图片 */
    private String productPic;

    /** 商品名称 */
    private String productName;

    /** 商品套餐编码 */
    private String productSkuCode;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date modifyDate;

    /** 是否删除 */
    private Integer deleteStatus;

    /** 商品编码 */
    private String productSn;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    private String productAttr;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
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

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public String getProductAttr() {
        return productAttr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("cartId", getCartId())
                .append("productId", getProductId())
                .append("productSkuId", getProductSkuId())
                .append("userId", getUserId())
                .append("quantity", getQuantity())
                .append("price", getPrice())
                .append("productPic", getProductPic())
                .append("productName", getProductName())
                .append("productSkuCode", getProductSkuCode())
                .append("createDate", getCreateDate())
                .append("modifyDate", getModifyDate())
                .append("deleteStatus", getDeleteStatus())
                .append("productSn", getProductSn())
                .append("productAttr", getProductAttr())
                .toString();
    }

}

