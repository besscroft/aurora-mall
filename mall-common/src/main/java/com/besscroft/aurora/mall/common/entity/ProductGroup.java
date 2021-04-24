package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品管理模块商品套餐对象 bms_product_group
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:17
 */
@TableName(value = "bms_product_group")
public class ProductGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 套餐对应的商品id */
    private Long productId;

    /** 套餐编码 */
    private String groupCode;

    /** 套餐价格 */
    private BigDecimal price;

    /** 库存 */
    private Long stock;

    /** 预警库存 */
    private Long lowStock;

    /** 展示图片 */
    private String pic;

    /** 销量 */
    private Long sale;

    /** 锁定库存 */
    private Long lockStock;

    /** 商品销售属性，以json格式保存 */
    private String spData;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
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

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Long getSale() {
        return sale;
    }

    public void setLockStock(Long lockStock) {
        this.lockStock = lockStock;
    }

    public Long getLockStock() {
        return lockStock;
    }

    public void setSpData(String spData) {
        this.spData = spData;
    }

    public String getSpData() {
        return spData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("productId", getProductId())
                .append("groupCode", getGroupCode())
                .append("price", getPrice())
                .append("stock", getStock())
                .append("lowStock", getLowStock())
                .append("pic", getPic())
                .append("sale", getSale())
                .append("lockStock", getLockStock())
                .append("spData", getSpData())
                .toString();
    }

}
