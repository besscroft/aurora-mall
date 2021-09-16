package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 商品管理模块商品对象 bms_product
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:12
 */
@TableName(value = "bms_product")
@ApiModel(value = "商品管理模块商品对象")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "id", dataType = "Long")
    private Long id;

    /** 商品id */
    @ApiModelProperty(value = "商品id", dataType = "String")
    private String productId;

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
    @ApiModelProperty(value = "商品类型id", dataType = "Long")
    private Long productTypeId;

    /** 商品类型名称 */
    @ApiModelProperty(value = "商品类型名称", dataType = "String")
    private String productTypeName;

    /** 商品分类id */
    @ApiModelProperty(value = "商品分类id", dataType = "Long")
    private Long productCategoryId;

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

    /** 库存 */
    @ApiModelProperty(value = "库存", dataType = "Long")
    private Long stock;

    /** 库存预警值 */
    @ApiModelProperty(value = "库存预警值", dataType = "Long")
    private Long lowStock;

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
    private LocalDate promotionStartTime;

    /** 促销结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "促销结束时间", dataType = "Date")
    private LocalDate promotionEndTime;

    /** 活动限购数量 */
    @ApiModelProperty(value = "活动限购数量", dataType = "Long")
    private Long promotionPerLimit;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    public Integer getNewStatus() {
        return newStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Long getSale() {
        return sale;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setAuroraPoint(Long auroraPoint) {
        this.auroraPoint = auroraPoint;
    }

    public Long getAuroraPoint() {
        return auroraPoint;
    }

    public void setAuroraBit(Long auroraBit) {
        this.auroraBit = auroraBit;
    }

    public Long getAuroraBit() {
        return auroraBit;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getStock() {
        return stock;
    }

    public void setLowStock(Long lowStock) {
        this.lowStock = lowStock;
    }

    public Long getLowStock() {
        return lowStock;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setPreviewStatus(Integer previewStatus) {
        this.previewStatus = previewStatus;
    }

    public Integer getPreviewStatus() {
        return previewStatus;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    public String getServiceIds() {
        return serviceIds;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml;
    }

    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setPromotionStartTime(LocalDate promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public LocalDate getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionEndTime(LocalDate promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public LocalDate getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionPerLimit(Long promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public Long getPromotionPerLimit() {
        return promotionPerLimit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productId", getProductId())
                .append("productSn", getProductSn())
                .append("name", getName())
                .append("pic", getPic())
                .append("brandId", getBrandId())
                .append("brandName", getBrandName())
                .append("productTypeId", getProductTypeId())
                .append("productTypeName", getProductTypeName())
                .append("productCategoryId", getProductCategoryId())
                .append("productCategoryName", getProductCategoryName())
                .append("pushStatus", getPushStatus())
                .append("newStatus", getNewStatus())
                .append("recommandStatus", getRecommandStatus())
                .append("verifyStatus", getVerifyStatus())
                .append("deleteStatus", getDeleteStatus())
                .append("sort", getSort())
                .append("sale", getSale())
                .append("price", getPrice())
                .append("auroraPoint", getAuroraPoint())
                .append("auroraBit", getAuroraBit())
                .append("subTitle", getSubTitle())
                .append("description", getDescription())
                .append("stock", getStock())
                .append("lowStock", getLowStock())
                .append("unit", getUnit())
                .append("weight", getWeight())
                .append("previewStatus", getPreviewStatus())
                .append("serviceIds", getServiceIds())
                .append("detailTitle", getDetailTitle())
                .append("detailHtml", getDetailHtml())
                .append("detailMobileHtml", getDetailMobileHtml())
                .append("promotionStartTime", getPromotionStartTime())
                .append("promotionEndTime", getPromotionEndTime())
                .append("promotionPerLimit", getPromotionPerLimit())
                .toString();
    }

}

