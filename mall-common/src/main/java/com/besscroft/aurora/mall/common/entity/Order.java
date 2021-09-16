package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 订单管理模块订单对象 bms_order
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:55
 */
@TableName(value = "bms_order")
@ApiModel(value = "订单管理模块订单对象")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单id", dataType = "Long")
    private Long id;

    /** 订单id */
    @ApiModelProperty(value = "订单id", dataType = "String")
    private String orderId;

    /** 订单编号 */
    @ApiModelProperty(value = "订单编号", dataType = "String")
    private String orderSn;

    /** 用户id */
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long userId;

    /** 优惠券id */
    @ApiModelProperty(value = "优惠券id", dataType = "Long")
    private Long couponId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDate createTime;

    /** 用户帐号 */
    @ApiModelProperty(value = "用户帐号", dataType = "String")
    private String memberUsername;

    /** 订单总金额 */
    @ApiModelProperty(value = "订单总金额", dataType = "BigDecimal")
    private BigDecimal totalAmount;

    /** 应付金额（实际支付金额） */
    @ApiModelProperty(value = "应付金额", dataType = "BigDecimal")
    private BigDecimal payAmount;

    /** 运费金额 */
    @ApiModelProperty(value = "运费金额", dataType = "BigDecimal")
    private BigDecimal freightAmount;

    /** 极光币抵扣金额 */
    @ApiModelProperty(value = "极光币抵扣金额", dataType = "BigDecimal")
    private BigDecimal auroraBitAmount;

    /** 优惠券抵扣金额 */
    @ApiModelProperty(value = "优惠券抵扣金额", dataType = "BigDecimal")
    private BigDecimal couponAmount;

    /** 管理员后台调整订单使用的折扣金额 */
    @ApiModelProperty(value = "管理员后台调整订单使用的折扣金额", dataType = "BigDecimal")
    private BigDecimal discountAmount;

    /** 支付方式：0->未支付；1->支付宝；2->微信 */
    @ApiModelProperty(value = "支付方式", dataType = "Integer")
    private Integer payType;

    /** 订单来源：0->PC订单；1->app订单 */
    @ApiModelProperty(value = "订单来源", dataType = "Integer")
    private Integer sourceType;

    /** 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单 */
    @ApiModelProperty(value = "订单状态", dataType = "Integer")
    private Integer status;

    /** 订单类型：0->正常订单；1->秒杀订单 */
    @ApiModelProperty(value = "订单类型", dataType = "Integer")
    private Integer orderType;

    /** 物流公司(配送方式) */
    @ApiModelProperty(value = "物流公司(配送方式)", dataType = "String")
    private String deliveryCompany;

    /** 物流单号 */
    @ApiModelProperty(value = "物流单号", dataType = "String")
    private String deliverySn;

    /** 自动确认时间（天） */
    @ApiModelProperty(value = "自动确认时间（天）", dataType = "Long")
    private Long autoConfirmDay;

    /** 可以获得的极光值 */
    @ApiModelProperty(value = "可以获得的极光值", dataType = "Long")
    private Long getAuroraPoint;

    /** 可以活动的极光币 */
    @ApiModelProperty(value = "可以活动的极光币", dataType = "Long")
    private Long getAuroraBit;

    /** 活动信息 */
    @ApiModelProperty(value = "活动信息", dataType = "String")
    private String promotionInfo;

    /** 发票类型：0->不开发票；1->电子发票；2->纸质发票 */
    @ApiModelProperty(value = "发票类型", dataType = "Integer")
    private Integer billType;

    /** 发票抬头 */
    @ApiModelProperty(value = "发票抬头", dataType = "String")
    private String billHeader;

    /** 发票内容 */
    @ApiModelProperty(value = "发票内容", dataType = "String")
    private String billContent;

    /** 收票人电话 */
    @ApiModelProperty(value = "收票人电话", dataType = "String")
    private String billReceiverPhone;

    /** 收票人邮箱 */
    @ApiModelProperty(value = "收票人邮箱", dataType = "String")
    private String billReceiverEmail;

    /** 收货人姓名 */
    @ApiModelProperty(value = "收货人姓名", dataType = "String")
    private String receiverName;

    /** 收货人电话 */
    @ApiModelProperty(value = "收货人电话", dataType = "String")
    private String receiverPhone;

    /** 收货人邮编 */
    @ApiModelProperty(value = "收货人邮编", dataType = "String")
    private String receiverPostCode;

    /** 省份/直辖市 */
    @ApiModelProperty(value = "省份/直辖市", dataType = "String")
    private String receiverProvince;

    /** 城市 */
    @ApiModelProperty(value = "城市", dataType = "String")
    private String receiverCity;

    /** 区 */
    @ApiModelProperty(value = "区", dataType = "String")
    private String receiverRegion;

    /** 详细地址 */
    @ApiModelProperty(value = "详细地址", dataType = "String")
    private String receiverDetailAddress;

    /** 订单备注 */
    @ApiModelProperty(value = "订单备注", dataType = "String")
    private String note;

    /** 确认收货状态：0->未确认；1->已确认 */
    @ApiModelProperty(value = "确认收货状态", dataType = "Integer")
    private Integer confirmStatus;

    /** 删除状态：0->未删除；1->已删除 */
    @ApiModelProperty(value = "删除状态", dataType = "Integer")
    private Integer deleteStatus;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "支付时间", dataType = "Date")
    private LocalDate paymentTime;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发货时间", dataType = "Date")
    private LocalDate deliveryTime;

    /** 确认收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "确认收货时间", dataType = "Date")
    private LocalDate receiveTime;

    /** 评价时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评价时间", dataType = "Date")
    private LocalDate commentTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", dataType = "Date")
    private LocalDate modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getAuroraBitAmount() {
        return auroraBitAmount;
    }

    public void setAuroraBitAmount(BigDecimal auroraBitAmount) {
        this.auroraBitAmount = auroraBitAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }

    public Long getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(Long autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    public Long getGetAuroraPoint() {
        return getAuroraPoint;
    }

    public void setGetAuroraPoint(Long getAuroraPoint) {
        this.getAuroraPoint = getAuroraPoint;
    }

    public Long getGetAuroraBit() {
        return getAuroraBit;
    }

    public void setGetAuroraBit(Long getAuroraBit) {
        this.getAuroraBit = getAuroraBit;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getBillHeader() {
        return billHeader;
    }

    public void setBillHeader(String billHeader) {
        this.billHeader = billHeader;
    }

    public String getBillContent() {
        return billContent;
    }

    public void setBillContent(String billContent) {
        this.billContent = billContent;
    }

    public String getBillReceiverPhone() {
        return billReceiverPhone;
    }

    public void setBillReceiverPhone(String billReceiverPhone) {
        this.billReceiverPhone = billReceiverPhone;
    }

    public String getBillReceiverEmail() {
        return billReceiverEmail;
    }

    public void setBillReceiverEmail(String billReceiverEmail) {
        this.billReceiverEmail = billReceiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public LocalDate getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDate paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDate getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDate deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public LocalDate getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDate receiveTime) {
        this.receiveTime = receiveTime;
    }

    public LocalDate getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDate commentTime) {
        this.commentTime = commentTime;
    }

    public LocalDate getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDate modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("orderId", getOrderId())
                .append("orderSn", getOrderSn())
                .append("userId", getUserId())
                .append("couponId", getCouponId())
                .append("createTime", getCreateTime())
                .append("memberUsername", getMemberUsername())
                .append("totalAmount", getTotalAmount())
                .append("payAmount", getPayAmount())
                .append("freightAmount", getFreightAmount())
                .append("auroraBitAmount", getAuroraBitAmount())
                .append("couponAmount", getCouponAmount())
                .append("discountAmount", getDiscountAmount())
                .append("payType", getPayType())
                .append("sourceType", getSourceType())
                .append("status", getStatus())
                .append("orderType", getOrderType())
                .append("deliveryCompany", getDeliveryCompany())
                .append("deliverySn", getDeliverySn())
                .append("autoConfirmDay", getAutoConfirmDay())
                .append("getAuroraPoint", getGetAuroraPoint())
                .append("getAuroraBit", getGetAuroraBit())
                .append("promotionInfo", getPromotionInfo())
                .append("billType", getBillType())
                .append("billHeader", getBillHeader())
                .append("billContent", getBillContent())
                .append("billReceiverPhone", getBillReceiverPhone())
                .append("billReceiverEmail", getBillReceiverEmail())
                .append("receiverName", getReceiverName())
                .append("receiverPhone", getReceiverPhone())
                .append("receiverPostCode", getReceiverPostCode())
                .append("receiverProvince", getReceiverProvince())
                .append("receiverCity", getReceiverCity())
                .append("receiverRegion", getReceiverRegion())
                .append("receiverDetailAddress", getReceiverDetailAddress())
                .append("note", getNote())
                .append("confirmStatus", getConfirmStatus())
                .append("deleteStatus", getDeleteStatus())
                .append("paymentTime", getPaymentTime())
                .append("deliveryTime", getDeliveryTime())
                .append("receiveTime", getReceiveTime())
                .append("commentTime", getCommentTime())
                .append("modifyTime", getModifyTime())
                .toString();
    }

}
