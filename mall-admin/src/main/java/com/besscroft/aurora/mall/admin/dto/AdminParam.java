package com.besscroft.aurora.mall.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 后台管理系统用户参数
 *
 * @Author Besscroft
 * @Date 2021/2/24 18:25
 */
@Data
public class AdminParam {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    @ApiModelProperty(value = "邮箱")
    @Email
    private String email;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "备注")
    private String note;

}
