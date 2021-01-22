package com.besscroft.aurora.mall.common.model.entity;

import com.besscroft.aurora.mall.common.model.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 购物车模块购物车对象 fms_car
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:35
 */
public class FmsCar extends BaseEntity {

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

