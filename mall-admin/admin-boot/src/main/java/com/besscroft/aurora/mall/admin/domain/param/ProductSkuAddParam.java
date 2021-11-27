package com.besscroft.aurora.mall.admin.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description 商品套餐新增请求参数
 * @Author Bess Croft
 * @Time 2021/11/27 19:51
 */
@Data
public class ProductSkuAddParam {

    /** 套餐对应的商品id */
    @NotNull(message = "商品id不能为空")
    @ApiModelProperty(value = "套餐对应的商品id", dataType = "String", required = true)
    private String productId;

    /** 套餐价格 */
    @NotNull(message = "套餐价格不能为空")
    @ApiModelProperty(value = "套餐价格", dataType = "BigDecimal", required = true)
    private BigDecimal price;

    /** 库存 */
    @NotNull(message = "套餐价格不能为空")
    @ApiModelProperty(value = "库存", dataType = "Long", required = true)
    private Long stock;

    /** 预警库存 */
    @ApiModelProperty(value = "预警库存", dataType = "Long")
    private Long lowStock;

    /** 展示图片 */
    @ApiModelProperty(value = "展示图片", dataType = "String")
    private String pic;

    /** 锁定库存 */
    @NotNull(message = "套餐价格不能为空")
    @ApiModelProperty(value = "锁定库存", dataType = "Long", required = true)
    private Long lockStock;

    /** 商品销售属性，以json格式保存 */
    @NotNull(message = "套餐价格不能为空")
    @ApiModelProperty(value = "商品销售属性", dataType = "String", required = true)
    private String spData;

}
