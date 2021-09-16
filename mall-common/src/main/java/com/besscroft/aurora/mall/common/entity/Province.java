package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 省份表对象
 *
 * @Author Besscroft
 * @Date 2021/4/26 16:41
 */
@TableName(value = "province")
@ApiModel(value = "省份表对象")
public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "省份id", dataType = "Integer")
    private Integer id;

    /** 省份名称 */
    @ApiModelProperty(value = "省份名称", dataType = "String")
    private String name;

    /** 省份代码 */
    @ApiModelProperty(value = "省份代码", dataType = "Integer")
    private Integer provinceCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("provinceCode", getProvinceCode())
                .toString();
    }

}
