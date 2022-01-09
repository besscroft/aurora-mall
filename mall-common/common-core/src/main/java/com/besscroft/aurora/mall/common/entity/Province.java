package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 省份表对象
 *
 * @Author Bess Croft
 * @Date 2021/4/26 16:41
 */
@Builder
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

}
