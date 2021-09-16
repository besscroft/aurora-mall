package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 商品管理模块商品品牌对象 bms_product_brand
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:16
 */
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

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("logo", getLogo())
                .append("showStatus", getShowStatus())
                .append("productCount", getProductCount())
                .append("bigPic", getBigPic())
                .append("sort", getSort())
                .toString();
    }

}
