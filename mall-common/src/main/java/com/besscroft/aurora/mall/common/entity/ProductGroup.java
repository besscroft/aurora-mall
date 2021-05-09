package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品管理模块商品套餐对象 bms_product_group
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:17
 */
@TableName(value = "bms_product_group")
@Document(indexName = "bms_product_group")
@ApiModel(value = "商品管理模块商品套餐对象")
public class ProductGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "商品套餐id", dataType = "Long")
    private Long id;

    /** 套餐对应的商品id */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "套餐对应的商品id", dataType = "Long")
    private Long productId;

    /** 套餐编码 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "套餐编码", dataType = "String")
    private String groupCode;

    /** 套餐价格 */
    @Field(type = FieldType.Integer_Range)
    @ApiModelProperty(value = "套餐价格", dataType = "BigDecimal")
    private BigDecimal price;

    /** 库存 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "库存", dataType = "Long")
    private Long stock;

    /** 预警库存 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "预警库存", dataType = "Long")
    private Long lowStock;

    /** 展示图片 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "展示图片", dataType = "String")
    private String pic;

    /** 销量 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "销量", dataType = "Long")
    private Long sale;

    /** 锁定库存 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "锁定库存", dataType = "Long")
    private Long lockStock;

    /** 商品销售属性，以json格式保存 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "商品销售属性", dataType = "String")
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
