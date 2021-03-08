package com.besscroft.aurora.mall.common.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 会员管理模块会员用户等级对象 bms_user_level
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:32
 */
public class BmsUserLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 等级名称 */
    private String name;

    /** 是否为默认等级：0->不是；1->是 */
    private Integer defaultStatus;

    /** 评价奖励的极光值 */
    private Long commentAuroraPoint;

    /** 购物奖励的极光值 */
    private Integer shopAuroraPoint;

    /** 评价奖励的极光币 */
    private Long commentAuroraBit;

    /** 购物奖励的极光币 */
    private Integer shopAuroraBit;

    /** 等级详情 */
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
