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
import java.time.LocalDateTime;

/**
 * 营销管理模块优惠券对象 bms_market_coupon
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:49
 */
@TableName(value = "bms_market_coupon")
@ApiModel(value = "营销管理模块优惠券对象")
public class MarketCoupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "优惠券id", dataType = "Long")
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStartMoney(BigDecimal startMoney) {
        this.startMoney = startMoney;
    }

    public BigDecimal getStartMoney() {
        return startMoney;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("couponId", getCouponId())
                .append("name", getName())
                .append("status", getStatus())
                .append("startMoney", getStartMoney())
                .append("money", getMoney())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("detail", getDetail())
                .append("sort", getSort())
                .toString();
    }

}
