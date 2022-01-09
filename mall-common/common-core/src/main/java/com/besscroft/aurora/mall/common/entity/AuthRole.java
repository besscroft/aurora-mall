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
 * 权限管理模块角色对象 bms_auth_role
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:41
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_auth_role")
@ApiModel(value = "权限管理模块角色对象")
public class AuthRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "角色id", dataType = "Long")
    private Long id;

    /** 名称 */
    @ApiModelProperty(value = "名称", dataType = "String")
    private String name;

    /** 描述 */
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;

    /** 用户数量 */
    @ApiModelProperty(value = "用户数量", dataType = "Long")
    private Long adminCount;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 启用状态：0->禁用；1->启用 */
    @ApiModelProperty(value = "启用状态", dataType = "Integer")
    private Integer status;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 假删除：0->删除状态；1->可用状态 */
    @ApiModelProperty(value = "假删除", dataType = "Integer")
    private Integer del;

}
