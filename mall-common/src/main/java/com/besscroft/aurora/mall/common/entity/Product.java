package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * 商品管理模块商品对象 bms_product
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_product")
@ApiModel(value = "商品管理模块商品对象")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "id", dataType = "String")
    private String id;

    /** 商品货号/编号 */
    @ApiModelProperty(value = "商品货号/编号", dataType = "String")
    private String productSn;

    /** 商品名称 */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String name;

    /** 商品图片 */
    @ApiModelProperty(value = "商品图片", dataType = "String")
    private String pic;

    /** 商品品牌id */
    @ApiModelProperty(value = "商品品牌id", dataType = "Long")
    private Long brandId;

    /** 品牌名称 */
    @ApiModelProperty(value = "品牌名称", dataType = "String")
    private String brandName;

    /** 商品类型id */
    @ApiModelProperty(value = "商品类型id", dataType = "String")
    private String productTypeId;

    /** 商品类型名称 */
    @ApiModelProperty(value = "商品类型名称", dataType = "String")
    private String productTypeName;

    /** 商品分类id */
    @ApiModelProperty(value = "商品分类id", dataType = "String")
    private String productCategoryId;

    /** 商品分类名称 */
    @ApiModelProperty(value = "商品分类名称", dataType = "String")
    private String productCategoryName;

    /** 上架状态：0->下架；1->上架 */
    @ApiModelProperty(value = "上架状态", dataType = "Integer")
    private Integer pushStatus;

    /** 新品状态:0->不是新品；1->新品 */
    @ApiModelProperty(value = "新品状态", dataType = "Integer")
    private Integer newStatus;

    /** 推荐状态；0->不推荐；1->推荐 */
    @ApiModelProperty(value = "推荐状态", dataType = "Integer")
    private Integer recommandStatus;

    /** 审核状态：0->未审核；1->审核通过 */
    @ApiModelProperty(value = "审核状态", dataType = "Integer")
    private Integer verifyStatus;

    /** 删除状态：0->未删除；1->已删除 */
    @ApiModelProperty(value = "删除状态", dataType = "Integer")
    private Integer deleteStatus;

    /** 排序，默认升序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 商品总销量 */
    @ApiModelProperty(value = "商品总销量", dataType = "Long")
    private Long sale;

    /** 标价 */
    @ApiModelProperty(value = "标价", dataType = "BigDecimal")
    private BigDecimal price;

    /** 赠送的极光值 */
    @ApiModelProperty(value = "赠送的极光值", dataType = "Long")
    private Long auroraPoint;

    /** 赠送的极光币 */
    @ApiModelProperty(value = "赠送的极光币", dataType = "Long")
    private Long auroraBit;

    /** 副标题 */
    @ApiModelProperty(value = "副标题", dataType = "Long")
    private String subTitle;

    /** 商品描述 */
    @ApiModelProperty(value = "商品描述", dataType = "String")
    private String description;

    /** 单位 */
    @ApiModelProperty(value = "单位", dataType = "String")
    private String unit;

    /** 商品重量，默认为克 */
    @ApiModelProperty(value = "商品重量，默认为克", dataType = "BigDecimal")
    private BigDecimal weight;

    /** 是否为秒杀商品：0->不是；1->是 */
    @ApiModelProperty(value = "是否为秒杀商品", dataType = "Integer")
    private Integer previewStatus;

    /** 以逗号分割的产品服务：1->包邮；2->急速退款；3->7天无理由；4->此商品不可用极光券 */
    @ApiModelProperty(value = "以逗号分割的产品服务", dataType = "String")
    private String serviceIds;

    /** 产品详情标题 */
    @ApiModelProperty(value = "产品详情标题", dataType = "String")
    private String detailTitle;

    /** 产品详情网页内容 */
    @ApiModelProperty(value = "产品详情网页内容", dataType = "String")
    private String detailHtml;

    /** 移动/小程序端网页详情 */
    @ApiModelProperty(value = "小程序端网页详情", dataType = "String")
    private String detailMobileHtml;

    /** 促销开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "促销开始时间", dataType = "Date")
    private LocalDateTime promotionStartTime;

    /** 促销结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "促销结束时间", dataType = "Date")
    private LocalDateTime promotionEndTime;

    /** 活动限购数量 */
    @ApiModelProperty(value = "活动限购数量", dataType = "Long")
    private Long promotionPerLimit;

    /** 创建人/所有人id */
    @ApiModelProperty(value = "创建人/所有人id", dataType = "Long")
    private Long createUserId;

}

