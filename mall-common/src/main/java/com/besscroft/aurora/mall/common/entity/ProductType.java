package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 商品管理模块商品类型对象 bms_product_type
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_product_type")
@ApiModel(value = "商品管理模块商品类型对象")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品类型id", dataType = "Long")
    private Long id;

    /** 类型名称 */
    @ApiModelProperty(value = "类型名称", dataType = "String")
    private String name;

    /** 属性数量，默认为0 */
    @ApiModelProperty(value = "属性数量，默认为0", dataType = "Long")
    private Long attributeCount;

    /** 参数数量，默认为0 */
    @ApiModelProperty(value = "参数数量，默认为0", dataType = "Long")
    private Long paramCount;

}
