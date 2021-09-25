package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 商品管理模块商品品牌对象 bms_product_brand
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_product_brand")
@ApiModel(value = "商品管理模块商品品牌对象")
public class ProductBrand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品品牌id", dataType = "Long")
    private Long id;

    /** 品牌名称 */
    @ApiModelProperty(value = "品牌名称", dataType = "String")
    private String name;

    /** 品牌logo */
    @ApiModelProperty(value = "品牌logo", dataType = "String")
    private String logo;

    /** 显示状态：0->不显示；1->显示 */
    @ApiModelProperty(value = "显示状态", dataType = "Integer")
    private Integer showStatus;

    /** 产品数量 */
    @ApiModelProperty(value = "产品数量", dataType = "Long")
    private Long productCount;

    /** 品牌专区大海报 */
    @ApiModelProperty(value = "品牌专区大海报", dataType = "String")
    private String bigPic;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

}
