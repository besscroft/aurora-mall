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
 * 权限管理模块资源对象 bms_auth_resource
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_auth_resource")
@ApiModel(value = "权限管理模块资源对象")
public class AuthResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "资源id", dataType = "Long")
    private Long id;

    /** 资源名称 */
    @ApiModelProperty(value = "资源名称", dataType = "String")
    private String name;

    /** 资源路径 */
    @ApiModelProperty(value = "资源路径", dataType = "String")
    private String url;

    /** 资源描述 */
    @ApiModelProperty(value = "资源描述", dataType = "String")
    private String description;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /** 资源类别ID */
    @ApiModelProperty(value = "资源类别ID", dataType = "Long")
    private Long categoryId;

}
