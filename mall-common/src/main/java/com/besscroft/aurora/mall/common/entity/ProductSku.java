package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品管理模块商品套餐对象 bms_product_sku
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_product_sku")
@ApiModel(value = "商品管理模块商品套餐对象")
public class ProductSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品套餐id", dataType = "Long")
    private Long id;

    /** 套餐对应的商品id */
    @ApiModelProperty(value = "套餐对应的商品id", dataType = "String")
    private String productId;

    /** 套餐编码 */
    @ApiModelProperty(value = "套餐编码", dataType = "String")
    private String skuCode;

    /** 套餐价格 */
    @ApiModelProperty(value = "套餐价格", dataType = "BigDecimal")
    private BigDecimal price;

    /** 库存 */
    @ApiModelProperty(value = "库存", dataType = "Long")
    private Long stock;

    /** 预警库存 */
    @ApiModelProperty(value = "预警库存", dataType = "Long")
    private Long lowStock;

    /** 展示图片 */
    @ApiModelProperty(value = "展示图片", dataType = "String")
    private String pic;

    /** 销量 */
    @ApiModelProperty(value = "销量", dataType = "Long")
    private Long sale;

    /** 锁定库存 */
    @ApiModelProperty(value = "锁定库存", dataType = "Long")
    private Long lockStock;

    /** 商品销售属性，以json格式保存 */
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
    private String spData;

}
