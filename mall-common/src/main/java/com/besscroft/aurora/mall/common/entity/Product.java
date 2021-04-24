package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品管理模块商品对象 bms_product
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:12
 */
@TableName(value = "bms_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 商品名称 */
    private String name;

    /** 商品图片 */
    private String pic;

    /** 商品品牌id */
    private Long brandId;

    /** 品牌名称 */
    private String brandName;

    /** 商品类型id */
    private Long productTypeId;

    /** 商品类型名称 */
    private String productTypeName;

    /** 商品分类id */
    private Long productCategoryId;

    /** 商品分类名称 */
    private String productCategoryName;

    /** 商品货号/编号 */
    private String productSn;

    /** 上架状态：0->下架；1->上架 */
    private Integer pushStatus;

    /** 新品状态:0->不是新品；1->新品 */
    private Integer newStatus;

    /** 推荐状态；0->不推荐；1->推荐 */
    private Integer recommandStatus;

    /** 审核状态：0->未审核；1->审核通过 */
    private Integer verifyStatus;

    /** 删除状态：0->未删除；1->已删除 */
    private Integer deleteStatus;

    /** 排序，默认升序 */
    private Long sort;

    /** 商品总销量 */
    private Long sale;

    /** 标价 */
    private BigDecimal price;

    /** 赠送的极光值 */
    private Long auroraPoint;

    /** 赠送的极光币 */
    private Long auroraBit;

    /** 副标题 */
    private String subTitle;

    /** 商品描述 */
    private String description;

    /** 库存 */
    private Long stock;

    /** 库存预警值 */
    private Long lowStock;

    /** 单位 */
    private String unit;

    /** 商品重量，默认为克 */
    private BigDecimal weight;

    /** 是否为秒杀商品：0->不是；1->是 */
    private Integer previewStatus;

    /** 以逗号分割的产品服务：1->包邮；2->急速退款；3->7天无理由；4->此商品不可用极光券 */
    private String serviceIds;

    /** 产品详情标题 */
    private String detailTitle;

    /** 产品详情网页内容 */
    private String detailHtml;

    /** 移动/小程序端网页详情 */
    private String detailMobileHtml;

    /** 促销开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date promotionStartTime;

    /** 促销结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date promotionEndTime;

    /** 活动限购数量 */
    private Long promotionPerLimit;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductSn() {
        return productSn;
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

    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public Date getPromotionEndTime() {
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
                .append("name", getName())
                .append("pic", getPic())
                .append("brandId", getBrandId())
                .append("brandName", getBrandName())
                .append("productTypeId", getProductTypeId())
                .append("productTypeName", getProductTypeName())
                .append("productCategoryId", getProductCategoryId())
                .append("productCategoryName", getProductCategoryName())
                .append("productSn", getProductSn())
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

