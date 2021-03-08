package com.besscroft.aurora.mall.common.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 会员管理模块会员用户等级对象 bms_user_grade
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:28
 */
public class BmsUserGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .toString();
    }

}

