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
 * 订单管理模块订单售后原因对象 bms_order_reason
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_order_reason")
@ApiModel(value = "订单管理模块订单售后原因对象")
public class OrderReason implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单售后原因id", dataType = "String")
    private String id;

    /** 原因类型 */
    @ApiModelProperty(value = "原因类型", dataType = "String")
    private String name;

    /** 是否启用：0->不启用；1->启用 */
    @ApiModelProperty(value = "是否启用", dataType = "Integer")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 收货备注 */
    @ApiModelProperty(value = "收货备注", dataType = "String")
    private String receiveNote;

}
