package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 订单管理模块订单定时任务对象 bms_order_timetask
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:08
 */
@TableName(value = "bms_order_timetask")
@ApiModel(value = "订单管理模块订单定时任务对象")
public class OrderTimetask implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "订单定时任务id", dataType = "Long")
    private Long id;

    /** 任务名称 */
    @ApiModelProperty(value = "任务名称", dataType = "String")
    private String name;

    /** 任务定时 */
    @ApiModelProperty(value = "任务定时", dataType = "Long")
    private Long flashTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 排序 */
    @ApiModelProperty(value = "排序", dataType = "Long")
    private Long sort;

    /** 任务详情 */
    @ApiModelProperty(value = "任务详情", dataType = "String")
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
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
