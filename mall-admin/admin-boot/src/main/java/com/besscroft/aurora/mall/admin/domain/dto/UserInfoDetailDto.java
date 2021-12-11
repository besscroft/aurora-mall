package com.besscroft.aurora.mall.admin.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description 用户详情 dto
 * @Author Bess Croft
 * @Time 2021/12/11 17:05
 */
@Data
@ApiModel(value = "用户详情 dto 对象")
public class UserInfoDetailDto {

    @ApiModelProperty(value = "会员用户信息id", dataType = "String")
    private String id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;

    /** 昵称 */
    @ApiModelProperty(value = "昵称", dataType = "String")
    private String nickname;

    /** 手机号码 */
    @ApiModelProperty(value = "手机号码", dataType = "String")
    private String phone;

    /** 帐号启用状态:0->禁用；1->启用 */
    @ApiModelProperty(value = "帐号启用状态", dataType = "Integer")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 头像 */
    @ApiModelProperty(value = "头像", dataType = "String")
    private String avatar;

    /** 性别：0->未知；1->男；2->女 */
    @ApiModelProperty(value = "性别", dataType = "Integer")
    private Integer gender;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生日", dataType = "Date")
    private LocalDateTime birthday;

    /** 所在城市 */
    @ApiModelProperty(value = "所在城市", dataType = "String")
    private String city;

    /** 职业 */
    @ApiModelProperty(value = "职业", dataType = "String")
    private String job;

    /** 个性签名 */
    @ApiModelProperty(value = "个性签名", dataType = "String")
    private String personalizedSignature;

    /** 用户注册来源 */
    @ApiModelProperty(value = "用户注册来源", dataType = "Integer")
    private Integer sourceType;

    /** 极光值 */
    @ApiModelProperty(value = "极光值", dataType = "Long")
    private Long auroraPoint;

    /** 极光币 */
    @ApiModelProperty(value = "极光币", dataType = "Long")
    private Long auroraBit;

}
