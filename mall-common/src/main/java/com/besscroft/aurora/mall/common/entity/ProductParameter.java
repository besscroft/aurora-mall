package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 商品管理模块商品类型参数对象 bms_product_parameter
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_product_parameter")
@ApiModel(value = "商品管理模块商品类型参数对象")
public class ProductParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品类型参数id", dataType = "Long")
    private Long id;

    /** 参数名称 */
    @ApiModelProperty(value = "参数名称", dataType = "String")
    private String paramName;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 参数选择类型：0->唯一；1->单选；2->多选 */
    @ApiModelProperty(value = "参数选择类型", dataType = "Integer")
    private Integer selectType;

    /** 参数录入方式：0->手工录入；1->从列表中选取 */
    @ApiModelProperty(value = "参数录入方式", dataType = "Integer")
    private Integer inputType;

    /** 分类筛选样式：1->普通；1->颜色 */
    @ApiModelProperty(value = "分类筛选样式", dataType = "Integer")
    private Integer filterType;

    /** 检索类型：0->不需要进行检索；1->关键字检索；2->范围检索 */
    @ApiModelProperty(value = "检索类型", dataType = "Integer")
    private Integer searchType;

    /** 相同参数产品是否关联：0->不关联；1->关联 */
    @ApiModelProperty(value = "相同参数产品是否关联", dataType = "Integer")
    private Integer relatedStatus;

    /** 是否支持手动新增：0->不支持；1->支持 */
    @ApiModelProperty(value = "是否支持手动新增", dataType = "Integer")
    private Integer handAddStatus;

    /** 参数的类型：0->规格；1->参数 */
    @ApiModelProperty(value = "参数的类型", dataType = "Integer")
    private Integer type;

    /** 参数值，以json格式保存 */
    @ApiModelProperty(value = "参数值", dataType = "String")
    private String value;

}
