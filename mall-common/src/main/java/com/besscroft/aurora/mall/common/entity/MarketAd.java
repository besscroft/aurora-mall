package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 营销管理模块广告（轮播图）对象 bms_market_ad
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_market_ad")
@ApiModel(value = "营销管理模块广告（轮播图）对象")
public class MarketAd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "广告id", dataType = "String")
    private String id;

    /** 广告名称 */
    @ApiModelProperty(value = "广告名称", dataType = "String")
    private String name;

    /** 轮播位置：0->PC首页轮播；1->app首页轮播 */
    @ApiModelProperty(value = "轮播位置", dataType = "Integer")
    private Integer type;

    /** 广告图片 */
    @ApiModelProperty(value = "广告图片", dataType = "String")
    private String pic;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始时间", dataType = "Date")
    private LocalDateTime startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束时间", dataType = "Date")
    private LocalDateTime endTime;

    /** 上下线状态：0->下线；1->上线 */
    @ApiModelProperty(value = "上下线状态", dataType = "Integer")
    private Integer status;

    /** 点击数 */
    @ApiModelProperty(value = "点击数", dataType = "Long")
    private Long clickCount;

    /** 下单数 */
    @ApiModelProperty(value = "下单数", dataType = "Long")
    private Long orderCount;

    /** 链接地址 */
    @ApiModelProperty(value = "链接地址", dataType = "Long")
    private String url;

    /** 详情 */
    @ApiModelProperty(value = "详情", dataType = "String")
    private String detail;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

}
