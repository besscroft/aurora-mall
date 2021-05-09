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

/**
 * 会员管理模块会员用户等级对象 bms_user_level
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:32
 */
@TableName(value = "bms_user_level")
@Document(indexName = "bms_user_level")
@ApiModel(value = "会员管理模块会员用户等级对象")
public class UserLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户等级id", dataType = "Long")
    private Long id;

    /** 等级名称 */
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "等级名称", dataType = "String")
    private String name;

    /** 是否为默认等级：0->不是；1->是 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "是否为默认等级", dataType = "Integer")
    private Integer defaultStatus;

    /** 评价奖励的极光值 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "评价奖励的极光值", dataType = "Long")
    private Long commentAuroraPoint;

    /** 购物奖励的极光值 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "购物奖励的极光值", dataType = "Integer")
    private Integer shopAuroraPoint;

    /** 评价奖励的极光币 */
    @Field(type = FieldType.Long)
    @ApiModelProperty(value = "评价奖励的极光币", dataType = "Long")
    private Long commentAuroraBit;

    /** 购物奖励的极光币 */
    @Field(type = FieldType.Integer)
    @ApiModelProperty(value = "购物奖励的极光币", dataType = "Integer")
    private Integer shopAuroraBit;

    /** 等级详情 */
    @Field(type = FieldType.Text)
    @ApiModelProperty(value = "等级详情", dataType = "String")
    private String detail;

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

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setCommentAuroraPoint(Long commentAuroraPoint) {
        this.commentAuroraPoint = commentAuroraPoint;
    }

    public Long getCommentAuroraPoint() {
        return commentAuroraPoint;
    }

    public void setShopAuroraPoint(Integer shopAuroraPoint) {
        this.shopAuroraPoint = shopAuroraPoint;
    }

    public Integer getShopAuroraPoint() {
        return shopAuroraPoint;
    }

    public void setCommentAuroraBit(Long commentAuroraBit) {
        this.commentAuroraBit = commentAuroraBit;
    }

    public Long getCommentAuroraBit() {
        return commentAuroraBit;
    }

    public void setShopAuroraBit(Integer shopAuroraBit) {
        this.shopAuroraBit = shopAuroraBit;
    }

    public Integer getShopAuroraBit() {
        return shopAuroraBit;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("defaultStatus", getDefaultStatus())
                .append("commentAuroraPoint", getCommentAuroraPoint())
                .append("shopAuroraPoint", getShopAuroraPoint())
                .append("commentAuroraBit", getCommentAuroraBit())
                .append("shopAuroraBit", getShopAuroraBit())
                .append("detail", getDetail())
                .toString();
    }

}
