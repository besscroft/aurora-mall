package com.besscroft.aurora.mall.admin.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 后台管理系统用户登录参数
 *
 * @Author Bess Croft
 * @Date 2021/2/17 18:06
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserLoginParam {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
