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
 * 订单管理模块订单定时任务对象 bms_order_timetask
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_order_timetask")
@ApiModel(value = "订单管理模块订单定时任务对象")
public class OrderTimetask implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单定时任务id", dataType = "String")
    private String id;

    /** 任务名称 */
    @ApiModelProperty(value = "任务名称", dataType = "String")
    private String name;

    /** 任务定时 */
    @ApiModelProperty(value = "任务定时", dataType = "Long")
    private Long flashTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 任务详情 */
    @ApiModelProperty(value = "任务详情", dataType = "String")
    private String detail;

}
