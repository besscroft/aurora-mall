package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 会员管理模块会员用户地址管理对象 bms_user_address
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_user_address")
@ApiModel(value = "会员管理模块会员用户地址管理对象")
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户地址id", dataType = "Long")
    private Long id;

    /** 用户id */
    @ApiModelProperty(value = "用户id", dataType = "Long")
    private Long userId;

    /** 收件人名称 */
    @ApiModelProperty(value = "id", dataType = "String")
    private String name;

    /** 收件人号码 */
    @ApiModelProperty(value = "收件人号码", dataType = "Long")
    private Long phoneNumber;

    /** 是否为默认：0->不是；1->是 */
    @ApiModelProperty(value = "是否为默认", dataType = "Integer")
    private Integer defaultStatus;

    /** 邮政编码 */
    @ApiModelProperty(value = "邮政编码", dataType = "String")
    private String postCode;

    /** 省份/直辖市 */
    @ApiModelProperty(value = "省份/直辖市", dataType = "String")
    private String province;

    /** 城市 */
    @ApiModelProperty(value = "城市", dataType = "String")
    private String city;

    /** 区 */
    @ApiModelProperty(value = "区", dataType = "String")
    private String region;

    /** 详细地址(街道) */
    @ApiModelProperty(value = "详细地址(街道)", dataType = "String")
    private String detailAddress;

}
