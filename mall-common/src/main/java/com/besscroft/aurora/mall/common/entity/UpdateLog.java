package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * 版本更新日志表对象 bms_update_log
 *
 * @Author Bess Croft
 * @Date 2021/4/17 21:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "bms_update_log")
@ApiModel(value = "版本更新日志表对象")
public class UpdateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "日志id", dataType = "Long")
    private Long id;

    /** 面板的name值 */
    @ApiModelProperty(value = "面板的name值", dataType = "Long")
    private Long name;

    /** 版本号 */
    @ApiModelProperty(value = "版本号", dataType = "String")
    private String title;

    /** 版本号图标 */
    @ApiModelProperty(value = "版本号图标", dataType = "String")
    private String titleIcon;

    /** 版本标签类型：默认->蓝色；success->绿色；info->灰色；warning->橙色；danger->红色 */
    @ApiModelProperty(value = "版本标签类型", dataType = "String")
    private String titleType;

    /** 版本标签内容 */
    @ApiModelProperty(value = "版本标签内容", dataType = "String")
    private String titleTagInfo;

    /** 版本标识 */
    @ApiModelProperty(value = "版本标识", dataType = "String")
    private String titleTag;

    /** 版本更新时间 */
    @ApiModelProperty(value = "版本更新时间", dataType = "String")
    private String titleTime;

    /** 子日志 */
    @ApiModelProperty(value = "子日志")
    private List<UpdateLogDetail> detail;

}
