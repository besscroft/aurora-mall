package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 会员管理模块会员用户等级对象 bms_user_level
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_user_level")
@ApiModel(value = "会员管理模块会员用户等级对象")
public class UserLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户等级id", dataType = "String")
    private String id;

    /** 等级名称 */
    @ApiModelProperty(value = "等级名称", dataType = "String")
    private String name;

    /** 是否为默认等级：0->不是；1->是 */
    @ApiModelProperty(value = "是否为默认等级", dataType = "Integer")
    private Integer defaultStatus;

    /** 评价奖励的极光值 */
    @ApiModelProperty(value = "评价奖励的极光值", dataType = "Long")
    private Long commentAuroraPoint;

    /** 购物奖励的极光值 */
    @ApiModelProperty(value = "购物奖励的极光值", dataType = "Integer")
    private Integer shopAuroraPoint;

    /** 评价奖励的极光币 */
    @ApiModelProperty(value = "评价奖励的极光币", dataType = "Long")
    private Long commentAuroraBit;

    /** 购物奖励的极光币 */
    @ApiModelProperty(value = "购物奖励的极光币", dataType = "Integer")
    private Integer shopAuroraBit;

    /** 等级详情 */
    @ApiModelProperty(value = "等级详情", dataType = "String")
    private String detail;

}
