package com.besscroft.aurora.mall.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Besscroft
 * @Date 2021/2/25 22:43
 */
@Data
public class BmsAdminInfoParam {

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像")
    private String icon;

}
