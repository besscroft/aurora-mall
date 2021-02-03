package com.besscroft.aurora.mall.common.entity;

import com.besscroft.aurora.mall.common.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品管理模块商品品牌对象 bms_product_brand
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:16
 */
public class BmsProductBrand extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 品牌名称 */
    private String name;

    /** 品牌logo */
    private String logo;

    /** 显示状态：0->不显示；1->显示 */
    private Integer showStatus;

    /** 产品数量 */
    private Long productCount;

    /** 品牌专区大海报 */
    private String bigPic;

    /** 排序 */
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
