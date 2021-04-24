package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 购物车模块购物车对象 ums_car
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:35
 */
@TableName(value = "ums_car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 用户id */
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .toString();
    }

}
