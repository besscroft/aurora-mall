package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车模块购物车子对象 ums_car_item
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:36
 */
@TableName(value = "ums_car_item")
@Document(indexName = "ums_car_item")
@ApiModel(value = "购物车模块购物车子对象")
public class CarItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "购物车子id", dataType = "Long")
    private Long id;

    /** 购物车id */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "购物车id", dataType = "String")
    private String cartId;

    /** 商品id */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "商品id", dataType = "String")
    private String productId;

    /** 商品套餐id */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "商品套餐id", dataType = "String")
    private String productSkuId;

    /** 用户id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long userId;

    /** 购买数量 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "购买数量", dataType = "Long")
    private Long quantity;

    /** 购物车商品价格 */
    @Field(type = FieldType.Integer_Range)
    @ApiModelProperty(value = "购物车商品价格", dataType = "BigDecimal")
    private BigDecimal price;

    /** 商品图片 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productPic;

    /** 商品名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /** 商品套餐编码 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品套餐编码", dataType = "String")
    private String productSkuCode;

    /** 创建时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private Date createDate;

    /** 修改时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "修改时间", dataType = "Date")
    private Date modifyDate;

    /** 是否删除 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "是否删除", dataType = "Integer")
    private Integer deleteStatus;

    /** 商品编码 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品编码", dataType = "String")
    private String productSn;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
    private String productAttr;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductSkuId(String productSkuId) {
        this.productSkuId = productSkuId;
    }

    public String getProductSkuId() {
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

