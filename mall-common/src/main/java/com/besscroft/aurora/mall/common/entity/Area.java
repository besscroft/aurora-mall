package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 区域表对象
 *
 * @Author Bess Croft
 * @Date 2021/4/26 16:40
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "area")
@ApiModel(value = "区域表对象")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "区域id", dataType = "Integer")
    private Integer id;

    /** 区域名称 */
    @ApiModelProperty(value = "区域名称", dataType = "String")
    private String name;

    /** 区域代码 */
    @ApiModelProperty(value = "区域代码", dataType = "Integer")
    private Integer areaCode;

    /** 城市代码 */
    @ApiModelProperty(value = "城市代码", dataType = "Integer")
    private Integer cityCode;

}
