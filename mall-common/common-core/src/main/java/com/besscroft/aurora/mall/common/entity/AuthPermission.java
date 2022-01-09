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
 * 权限管理模块权限对象 bms_auth_permission
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_auth_permission")
@ApiModel(value = "权限管理模块权限对象")
public class AuthPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "权限id", dataType = "Long")
    private Long id;

    /** 父级权限id */
    @ApiModelProperty(value = "父级权限id", dataType = "Long")
    private Long pid;

    /** 名称 */
    @ApiModelProperty(value = "名称", dataType = "String")
    private String name;

    /** 权限值 */
    @ApiModelProperty(value = "权限值", dataType = "String")
    private String value;

    /** 图标 */
    @ApiModelProperty(value = "图标", dataType = "String")
    private String icon;

    /** 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限） */
    @ApiModelProperty(value = "父级ID", dataType = "Long")
    private Integer type;

    /** 前端资源路径 */
    @ApiModelProperty(value = "父级ID", dataType = "Long")
    private String uri;

    /** 启用状态；0->禁用；1->启用 */
    @ApiModelProperty(value = "启用状态", dataType = "Integer")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

}
