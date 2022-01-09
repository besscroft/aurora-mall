package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 会员管理模块会员用户等级规则对象 bms_user_grade_rule
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_user_grade_rule")
@ApiModel(value = "会员管理模块会员用户等级规则对象")
public class UserGradeRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户等级规则id", dataType = "String")
    private String id;

    /** 等级名称 */
    @ApiModelProperty(value = "等级名称", dataType = "String")
    private String name;

    /** 到达当前等级需要的极光值 */
    @ApiModelProperty(value = "到达当前等级需要的极光值", dataType = "Integer")
    private Integer auroraPoint;

    /** 等级详情 */
    @ApiModelProperty(value = "等级详情", dataType = "String")
    private String detail;

}
