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
 * 订单管理模块订单售后对象 bms_order_return
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:05
 */
@TableName(value = "bms_order_return")
@Document(indexName = "bms_order_return")
@ApiModel(value = "订单管理模块订单售后对象")
public class OrderReturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单售后id", dataType = "Long")
    private Long id;

    /** 订单id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "订单id", dataType = "Long")
    private Long orderId;

    /** 收货地址表id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "收货地址表id", dataType = "Long")
    private Long companyAddressId;

    /** 退货商品id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "退货商品id", dataType = "Long")
    private Long productId;

    /** 订单编号 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "订单编号", dataType = "String")
    private String orderSn;

    /** 创建时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private Date createTime;

    /** 会员用户名 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "会员用户名", dataType = "String")
    private String memberUsername;

    /** 退款金额 */
    @Field(type = FieldType.Integer_Range)
    @ApiModelProperty(value = "退款金额", dataType = "BigDecimal")
    private BigDecimal returnAmount;

    /** 退货人姓名 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "退货人姓名", dataType = "String")
    private String returnName;

    /** 退货人电话 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "退货人电话", dataType = "String")
    private String returnPhone;

    /** 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "申请状态", dataType = "Integer")
    private Integer status;

    /** 处理时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "处理时间", dataType = "Date")
    private Date handleTime;

    /** 商品图片 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productPic;

    /** 商品名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /** 商品品牌 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "商品品牌", dataType = "String")
    private String productBrand;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
    private String productSkuAttr;

    /** 退货数量 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "退货数量", dataType = "Long")
    private Long productCount;

    /** 商品单价 */
    @Field(type = FieldType.Integer_Range)
    @ApiModelProperty(value = "商品单价", dataType = "BigDecimal")
    private BigDecimal productPrice;

    /** 商品实际支付单价 */
    @Field(type = FieldType.Integer_Range)
    @ApiModelProperty(value = "商品实际支付单价", dataType = "BigDecimal")
    private BigDecimal productRealPrice;

    /** 原因 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "原因", dataType = "String")
    private String reason;

    /** 描述 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;

    /** 凭证图片，以逗号隔开 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "凭证图片，以逗号隔开", dataType = "String")
    private String proofPics;

    /** 处理备注 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "处理备注", dataType = "String")
    private String handleNote;

    /** 处理人员 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "处理人员", dataType = "String")
    private String handleMan;

    /** 收货人 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "收货人", dataType = "String")
    private String receiveMan;

    /** 收货时间 */
    @Field(type = FieldType.Date)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "收货时间", dataType = "Date")
    private Date receiveTime;

    /** 收货备注 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "收货备注", dataType = "String")
    private String receiveNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnPhone() {
        return returnPhone;
    }

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductSkuAttr() {
        return productSkuAttr;
    }

    public void setProductSkuAttr(String productSkuAttr) {
        this.productSkuAttr = productSkuAttr;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductRealPrice() {
        return productRealPrice;
    }

    public void setProductRealPrice(BigDecimal productRealPrice) {
        this.productRealPrice = productRealPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProofPics() {
        return proofPics;
    }

    public void setProofPics(String proofPics) {
        this.proofPics = proofPics;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderId", getOrderId())
                .append("companyAddressId", getCompanyAddressId())
                .append("productId", getProductId())
                .append("orderSn", getOrderSn())
                .append("createTime", getCreateTime())
                .append("memberUsername", getMemberUsername())
                .append("returnAmount", getReturnAmount())
                .append("returnName", getReturnName())
                .append("returnPhone", getReturnPhone())
                .append("status", getStatus())
                .append("handleTime", getHandleTime())
                .append("productPic", getProductPic())
                .append("productName", getProductName())
                .append("productBrand", getProductBrand())
                .append("productSkuAttr", getProductSkuAttr())
                .append("productCount", getProductCount())
                .append("productPrice", getProductPrice())
                .append("productRealPrice", getProductRealPrice())
                .append("reason", getReason())
                .append("description", getDescription())
                .append("proofPics", getProofPics())
                .append("handleNote", getHandleNote())
                .append("handleMan", getHandleMan())
                .append("receiveMan", getReceiveMan())
                .append("receiveTime", getReceiveTime())
                .append("receiveNote", getReceiveNote())
                .toString();
    }

}
