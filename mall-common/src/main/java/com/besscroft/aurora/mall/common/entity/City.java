package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 城市表对象
 *
 * @Author Bess Croft
 * @Date 2021/4/26 16:40
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "city")
@ApiModel(value = "城市表对象")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "城市id", dataType = "Integer")
    private Integer id;

    /** 城市名称 */
    @ApiModelProperty(value = "城市名称", dataType = "String")
    private String name;

    /** 城市代码 */
    @ApiModelProperty(value = "城市代码", dataType = "Integer")
    private Integer cityCode;

    /** 省份代码 */
    @ApiModelProperty(value = "省份代码", dataType = "Integer")
    private Integer provinceCode;

}
