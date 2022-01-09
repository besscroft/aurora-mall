package com.besscroft.aurora.mall.common.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.besscroft.aurora.mall.common.converter.LocalDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description 商品信息导出数据对象
 * @Author Bess Croft
 * @Time 2021/10/14 14:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductExcelDto {

    @ExcelProperty("商品id")
    private String id;

    /** 商品货号/编号 */
    @ExcelProperty("商品货号/编号")
    private String productSn;

    /** 商品名称 */
    @ExcelProperty("商品名称")
    private String name;

    /** 商品图片 */
    @ExcelProperty("商品图片")
    private String pic;

    /** 品牌名称 */
    @ExcelProperty("品牌名称")
    private String brandName;

    /** 商品类型名称 */
    @ExcelProperty("商品类型名称")
    private String productTypeName;

    /** 商品分类名称 */
    @ExcelProperty("商品分类名称")
    private String productCategoryName;

    /** 上架状态：0->下架；1->上架 */
    @ExcelProperty("上架状态")
    private String pushStatus;

    /** 新品状态:0->不是新品；1->新品 */
    @ExcelProperty("新品状态")
    private String newStatus;

    /** 推荐状态；0->不推荐；1->推荐 */
    @ExcelProperty("推荐状态")
    private String recommandStatus;

    /** 审核状态：0->未审核；1->审核通过 */
    @ExcelProperty("审核状态")
    private String verifyStatus;

    /** 删除状态：0->未删除；1->已删除 */
    @ExcelProperty("删除状态")
    private String deleteStatus;

    /** 排序，默认升序 */
    @ExcelProperty("排序，默认升序")
    private Long sort;

    /** 商品总销量 */
    @ExcelProperty("商品总销量")
    private Long sale;

    /** 标价 */
    @ExcelProperty("标价")
    private BigDecimal price;

    /** 赠送的极光值 */
    @ExcelProperty("赠送的极光值")
    private Long auroraPoint;

    /** 赠送的极光币 */
    @ExcelProperty("赠送的极光币")
    private Long auroraBit;

    /** 副标题 */
    @ExcelProperty("副标题")
    private String subTitle;

    /** 商品描述 */
    @ExcelProperty("商品描述")
    private String description;

    /** 单位 */
    @ExcelProperty("单位")
    private String unit;

    /** 商品重量，默认为克 */
    @ExcelProperty("商品重量，默认为克")
    private BigDecimal weight;

    /** 是否为秒杀商品：0->不是；1->是 */
    @ExcelProperty("是否为秒杀商品")
    private String previewStatus;

    /** 以逗号分割的产品服务：1->包邮；2->急速退款；3->7天无理由；4->此商品不可用极光券 */
    @ExcelProperty("产品服务")
    private String serviceIds;

    /** 产品详情标题 */
    @ExcelProperty("产品详情标题")
    private String detailTitle;

    /** 产品详情网页内容 */
    @ExcelProperty("产品详情网页内容")
    private String detailHtml;

    /** 移动/小程序端网页详情 */
    @ExcelProperty("移动/小程序端网页详情")
    private String detailMobileHtml;

    /** 促销开始时间 */
    @ExcelProperty(value = "促销开始时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime promotionStartTime;

    /** 促销结束时间 */
    @ExcelProperty(value = "促销结束时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime promotionEndTime;

    /** 活动限购数量 */
    @ExcelProperty("活动限购数量")
    private Long promotionPerLimit;

    /** 创建人/所有人 */
    @ExcelProperty("所有人")
    private String createUser;

}
