package com.besscroft.aurora.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销管理模块广告（轮播图）对象 bms_market_ad
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:46
 */
public class BmsMarketAd implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 广告名称 */
    private String name;

    /** 轮播位置：0->PC首页轮播；1->app首页轮播 */
    private Integer type;

    /** 广告图片 */
    private String pic;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 上下线状态：0->下线；1->上线 */
    private Integer status;

    /** 点击数 */
    private Long clickCount;

    /** 下单数 */
    private Long orderCount;

    /** 链接地址 */
    private String url;

    /** 详情 */
    private String detail;

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
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
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
                .append("type", getType())
                .append("pic", getPic())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("status", getStatus())
                .append("clickCount", getClickCount())
                .append("orderCount", getOrderCount())
                .append("url", getUrl())
                .append("detail", getDetail())
                .append("sort", getSort())
                .toString();
    }

}
