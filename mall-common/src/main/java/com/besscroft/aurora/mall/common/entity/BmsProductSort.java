package com.besscroft.aurora.mall.common.entity;

import com.besscroft.aurora.mall.common.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品管理模块商品分类对象 bms_product_sort
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:22
 */
public class BmsProductSort extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 父id：0表示一级分类 */
    private Long parentId;

    /** 分类名称 */
    private String name;

    /** 分类级别：0->1级；1->2级 */
    private Integer level;

    /** 显示状态：0->不显示；1->显示 */
    private Integer showStatus;

    /** 排序 */
    private Long sort;

    /** 图标 */
    private String icon;

    /** 描述 */
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("parentId", getParentId())
                .append("name", getName())
                .append("level", getLevel())
                .append("showStatus", getShowStatus())
                .append("sort", getSort())
                .append("icon", getIcon())
                .append("description", getDescription())
                .toString();
    }

}
