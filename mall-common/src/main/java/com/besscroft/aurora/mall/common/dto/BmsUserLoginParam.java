package com.besscroft.aurora.mall.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 后台管理系统用户登录参数
 *
 * @Author Besscroft
 * @Date 2021/1/23 14:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BmsUserLoginParam {

    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
