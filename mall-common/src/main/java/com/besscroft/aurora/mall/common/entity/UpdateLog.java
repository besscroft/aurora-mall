package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * 版本更新日志表对象 bms_update_log
 *
 * @Author Besscroft
 * @Date 2021/4/17 21:20
 */
@TableName(value = "bms_update_log")
public class UpdateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 面板的name值 */
    private Long name;

    /** 版本号 */
    private String title;

    /** 版本号图标 */
    private String titleIcon;

    /** 版本标签类型：默认->蓝色；success->绿色；info->灰色；warning->橙色；danger->红色 */
    private String titleType;

    /** 版本标签内容 */
    private String titleTagInfo;

    /** 版本标识 */
    private String titleTag;

    /** 版本更新时间 */
    private String titleTime;

    /** 子日志 */
    private List<UpdateLogDetail> detail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleIcon() {
        return titleIcon;
    }

    public void setTitleIcon(String titleIcon) {
        this.titleIcon = titleIcon;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getTitleTagInfo() {
        return titleTagInfo;
    }

    public void setTitleTagInfo(String titleTagInfo) {
        this.titleTagInfo = titleTagInfo;
    }

    public String getTitleTag() {
        return titleTag;
    }

    public void setTitleTag(String titleTag) {
        this.titleTag = titleTag;
    }

    public String getTitleTime() {
        return titleTime;
    }

    public void setTitleTime(String titleTime) {
        this.titleTime = titleTime;
    }

    public List<UpdateLogDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<UpdateLogDetail> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("title", getTitle())
                .append("titleIcon", getTitleIcon())
                .append("titleType", getTitleType())
                .append("titleTagInfo", getTitleTagInfo())
                .append("titleTag", getTitleTag())
                .append("titleTime", getTitleTime())
                .append("detail", getDetail())
                .toString();
    }

}
