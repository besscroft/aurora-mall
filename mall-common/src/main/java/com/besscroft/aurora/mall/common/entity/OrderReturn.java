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
 * 订单管理模块订单售后对象 bms_order_return
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_order_return")
@ApiModel(value = "订单管理模块订单售后对象")
public class OrderReturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单售后id", dataType = "Long")
    private Long id;

    /** 订单id */
    @ApiModelProperty(value = "订单id", dataType = "Long")
    private Long orderId;

    /** 收货地址表id */
    @ApiModelProperty(value = "收货地址表id", dataType = "Long")
    private Long companyAddressId;

    /** 退货商品id */
    @ApiModelProperty(value = "退货商品id", dataType = "Long")
    private Long productId;

    /** 订单编号 */
    @ApiModelProperty(value = "订单编号", dataType = "String")
    private String orderSn;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 会员用户名 */
    @ApiModelProperty(value = "会员用户名", dataType = "String")
    private String memberUsername;

    /** 退款金额 */
    @ApiModelProperty(value = "退款金额", dataType = "BigDecimal")
    private BigDecimal returnAmount;

    /** 退货人姓名 */
    @ApiModelProperty(value = "退货人姓名", dataType = "String")
    private String returnName;

    /** 退货人电话 */
    @ApiModelProperty(value = "退货人电话", dataType = "String")
    private String returnPhone;

    /** 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝 */
    @ApiModelProperty(value = "申请状态", dataType = "Integer")
    private Integer status;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "处理时间", dataType = "Date")
    private LocalDateTime handleTime;

    /** 商品图片 */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String productPic;

    /** 商品名称 */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /** 商品品牌 */
    @ApiModelProperty(value = "商品品牌", dataType = "String")
    private String productBrand;

    /** 商品销售属性:[{"key":"颜色","value":"蓝色"},{"key":"尺寸","value":"24英寸"}] */
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
    private String productSkuAttr;

    /** 退货数量 */
    @ApiModelProperty(value = "退货数量", dataType = "Long")
    private Long productCount;

    /** 商品单价 */
    @ApiModelProperty(value = "商品单价", dataType = "BigDecimal")
    private BigDecimal productPrice;

    /** 商品实际支付单价 */
    @ApiModelProperty(value = "商品实际支付单价", dataType = "BigDecimal")
    private BigDecimal productRealPrice;

    /** 原因 */
    @ApiModelProperty(value = "原因", dataType = "String")
    private String reason;

    /** 描述 */
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;

    /** 凭证图片，以逗号隔开 */
    @ApiModelProperty(value = "凭证图片，以逗号隔开", dataType = "String")
    private String proofPics;

    /** 处理备注 */
    @ApiModelProperty(value = "处理备注", dataType = "String")
    private String handleNote;

    /** 处理人员 */
    @ApiModelProperty(value = "处理人员", dataType = "String")
    private String handleMan;

    /** 收货人 */
    @ApiModelProperty(value = "收货人", dataType = "String")
    private String receiveMan;

    /** 收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "收货时间", dataType = "Date")
    private LocalDateTime receiveTime;

    /** 收货备注 */
    @ApiModelProperty(value = "收货备注", dataType = "String")
    private String receiveNote;

}
