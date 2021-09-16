package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 会员管理模块会员用户等级规则对象 bms_user_grade_rule
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:29
 */
@TableName(value = "bms_user_grade_rule")
@ApiModel(value = "会员管理模块会员用户等级规则对象")
public class UserGradeRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户等级规则id", dataType = "Long")
    private Long id;

    /** 等级名称 */
    @ApiModelProperty(value = "等级名称", dataType = "String")
    private String name;

    /** 到达当前等级需要的极光值 */
    @ApiModelProperty(value = "到达当前等级需要的极光值", dataType = "Integer")
    private Integer auroraPoint;

    /** 等级详情 */
    @ApiModelProperty(value = "等级详情", dataType = "String")
    private String detail;

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

    public void setAuroraPoint(Integer auroraPoint) {
        this.auroraPoint = auroraPoint;
    }

    public Integer getAuroraPoint() {
        return auroraPoint;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("auroraPoint", getAuroraPoint())
                .append("detail", getDetail())
                .toString();
    }

}
