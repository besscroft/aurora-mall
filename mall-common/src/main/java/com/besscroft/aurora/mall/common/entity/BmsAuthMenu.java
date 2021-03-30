package com.besscroft.aurora.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限管理模块菜单对象 bms_auth_menu
 *
 * @Author Besscroft
 * @Date 2021/1/22 20:26
 */
public class BmsAuthMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 父级ID */
    private Long parentId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 菜单名称 */
    private String title;

    /** 父菜单名称 */
    private String parentTitle;

    /** 菜单级数 */
    private Integer level;

    /** 菜单排序 */
    private Integer sort;

    /** 前端名称 */
    private String name;

    /** 路由地址 */
    private String path;

    /** 前端图标 */
    private String icon;

    /** 显示状态：0->不显示；1->显示 */
    private Integer hidden;

    /** 组件路径 */
    private String component;

    /** 子菜单 **/
    private List<BmsAuthMenu> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public List<BmsAuthMenu> getChildren() {
        return children;
    }

    public void setChildren(List<BmsAuthMenu> children) {
        this.children = children;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("parentId", getParentId())
                .append("createTime", getCreateTime())
                .append("title", getTitle())
                .append("parentTitle", getParentTitle())
                .append("level", getLevel())
                .append("sort", getSort())
                .append("name", getName())
                .append("path", getPath())
                .append("icon", getIcon())
                .append("hidden", getHidden())
                .append("children", getChildren())
                .append("component", getComponent())
                .toString();
    }
}