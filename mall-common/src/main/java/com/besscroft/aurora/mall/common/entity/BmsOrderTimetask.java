package com.besscroft.aurora.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单管理模块订单定时任务对象 bms_order_timetask
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:08
 */
public class BmsOrderTimetask implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 任务名称 */
    private String name;

    /** 任务定时 */
    private Long flashTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 排序 */
    private Long sort;

    /** 任务详情 */
    private String detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFlashTime() {
        return flashTime;
    }

    public void setFlashTime(Long flashTime) {
        this.flashTime = flashTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("flashTime", getFlashTime())
                .append("createTime", getCreateTime())
                .append("sort", getSort())
                .append("detail", getDetail())
                .toString();
    }

}
