package com.besscroft.aurora.mall.common.model.entity;

import com.besscroft.aurora.mall.common.model.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 营销管理模块极光币对象 bms_market_bit
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:48
 */
public class BmsMarketBit extends BaseEntity {

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
