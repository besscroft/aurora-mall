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
 * 订单管理模块订单对象 bms_order
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_order")
@ApiModel(value = "订单管理模块订单对象")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单id", dataType = "String")
    private String id;

    /** 订单编号 */
    @ApiModelProperty(value = "订单编号", dataType = "String")
    private String orderSn;

    /** 用户id */
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long userId;

    /** 优惠券id */
    @ApiModelProperty(value = "优惠券id", dataType = "String")
    private String couponId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

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
    private LocalDateTime paymentTime;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发货时间", dataType = "Date")
    private LocalDateTime deliveryTime;

    /** 确认收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "确认收货时间", dataType = "Date")
    private LocalDateTime receiveTime;

    /** 评价时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "评价时间", dataType = "Date")
    private LocalDateTime commentTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", dataType = "Date")
    private LocalDateTime modifyTime;

}
