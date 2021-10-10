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
 * 营销管理模块优惠券对象 bms_market_coupon
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_market_coupon")
@ApiModel(value = "营销管理模块优惠券对象")
public class MarketCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "优惠券id", dataType = "String")
    private String id;

    /** 优惠券id */
    @ApiModelProperty(value = "优惠券id", dataType = "String")
    private String couponId;

    /** 极光券名称 */
    @ApiModelProperty(value = "极光券名称", dataType = "String")
    private String name;

    /** 是否可用：0->下线；1->上线 */
    @ApiModelProperty(value = "是否可用", dataType = "Integer")
    private Integer status;

    /** 生效金额门槛 */
    @ApiModelProperty(value = "生效金额门槛", dataType = "BigDecimal")
    private BigDecimal startMoney;

    /** 抵扣金额 */
    @ApiModelProperty(value = "抵扣金额", dataType = "BigDecimal")
    private BigDecimal money;

    /** 生效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生效时间", dataType = "Date")
    private LocalDateTime startTime;

    /** 失效时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "失效时间", dataType = "Date")
    private LocalDateTime endTime;

    /** 详情 */
    @ApiModelProperty(value = "详情", dataType = "String")
    private String detail;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

}
