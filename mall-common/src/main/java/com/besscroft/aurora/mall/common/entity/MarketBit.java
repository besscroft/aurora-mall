package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 营销管理模块极光币对象 bms_market_bit
 *
 * @Author Bess Croft
 * @Date 2021/1/22 20:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_market_bit")
@ApiModel(value = "营销管理模块极光币对象")
public class MarketBit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "极光币id", dataType = "Long")
    private Long id;

}
