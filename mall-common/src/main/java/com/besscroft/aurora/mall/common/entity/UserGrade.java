package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 会员管理模块会员用户等级对象 bms_user_grade
 *
 * @Author Bess Croft
 * @Date 2021/1/22 21:28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_user_grade")
@ApiModel(value = "会员管理模块会员用户等级对象")
public class UserGrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户等级id", dataType = "Long")
    private Long id;

}

