package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 商品管理模块商品分类对象 bms_product_sort
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_product_sort")
@ApiModel(value = "商品管理模块商品分类对象")
public class ProductSort implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品分类id", dataType = "String")
    private String id;

    /** 父id：0表示一级分类 */
    @ApiModelProperty(value = "父id", dataType = "String")
    private String parentId;

    /** 分类名称 */
    @ApiModelProperty(value = "分类名称", dataType = "String")
    private String name;

    /** 分类级别：0->1级；1->2级 */
    @ApiModelProperty(value = "分类级别", dataType = "Integer")
    private Integer level;

    /** 显示状态：0->不显示；1->显示 */
    @ApiModelProperty(value = "显示状态", dataType = "Integer")
    private Integer showStatus;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 图标 */
    @ApiModelProperty(value = "图标", dataType = "String")
    private String icon;

    /** 描述 */
    @ApiModelProperty(value = "描述", dataType = "String")
    private String description;

}
