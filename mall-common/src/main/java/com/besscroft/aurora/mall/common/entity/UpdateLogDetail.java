package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 版本更新日志子表对象
 *
 * @Author Bess Croft
 * @Date 2021/4/17 21:21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_update_log_detail")
@ApiModel(value = "版本更新日志子表对象")
public class UpdateLogDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "日志子id", dataType = "String")
    private String id;

    /** 更新日志id */
    @ApiModelProperty(value = "更新日志id", dataType = "String")
    private String logId;

    /** 日志内容 */
    @ApiModelProperty(value = "日志内容", dataType = "String")
    private String body;

}
