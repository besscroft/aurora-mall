package com.besscroft.aurora.mall.common.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.besscroft.aurora.mall.common.converter.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 权限管理模块用户对象 bms_auth_user
 *
 * @Author Bess Croft
 * @Date 2021/1/22 19:50
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_auth_user")
@ApiModel(value = "权限管理模块用户对象")
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Id
    @ApiModelProperty(value = "用户id", dataType = "Long")
    @ExcelProperty("用户id")
    private Long id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", dataType = "String")
    @ExcelProperty("用户名")
    private String username;

    /** 密码 */
    @ApiModelProperty(value = "密码", dataType = "String")
    @ExcelProperty("密码")
    private String password;

    /** 头像 */
    @ApiModelProperty(value = "头像", dataType = "String")
    @ExcelProperty("头像")
    private String icon;

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱", dataType = "String")
    @ExcelProperty("邮箱")
    private String email;

    /** 手机 */
    @ApiModelProperty(value = "手机", dataType = "String")
    @ExcelProperty("手机")
    private String phone;

    /** 昵称 */
    @ApiModelProperty(value = "昵称", dataType = "String")
    @ExcelProperty("昵称")
    private String nickName;

    /** 备注信息 */
    @ApiModelProperty(value = "备注信息", dataType = "String")
    @ExcelProperty("备注信息")
    private String note;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    @ExcelProperty(value = "创建时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime createTime;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后登录时间", dataType = "Date")
    @ExcelProperty(value = "最后登录时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime loginTime;

    /** 帐号启用状态：0->禁用；1->启用 */
    @ApiModelProperty(value = "帐号启用状态", dataType = "Integer")
    @ExcelProperty("帐号启用状态")
    private Integer status;

    /** 假删除：0->删除状态；1->可用状态 */
    @ApiModelProperty(value = "假删除", dataType = "Integer")
    @ExcelProperty("假删除")
    private Integer del;

}
