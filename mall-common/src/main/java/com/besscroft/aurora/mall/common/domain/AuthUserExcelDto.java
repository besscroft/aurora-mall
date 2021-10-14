package com.besscroft.aurora.mall.common.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.besscroft.aurora.mall.common.converter.LocalDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description 管理系统用户导出数据对象
 * @Author Bess Croft
 * @Time 2021/10/14 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserExcelDto {

    /** 用户id */
    @ExcelProperty("用户id")
    private Long id;

    /** 用户名 */
    @ExcelProperty("用户名")
    private String username;

    /** 头像 */
    @ExcelProperty("头像")
    private String icon;

    /** 邮箱 */
    @ExcelProperty("邮箱")
    private String email;

    /** 手机 */
    @ExcelProperty("手机")
    private String phone;

    /** 昵称 */
    @ExcelProperty("昵称")
    private String nickName;

    /** 备注信息 */
    @ExcelProperty("备注信息")
    private String note;

    /** 创建时间 */
    @ExcelProperty(value = "创建时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime createTime;

    /** 最后登录时间 */
    @ExcelProperty(value = "最后登录时间", converter = LocalDateTimeConverter.class)
    private LocalDateTime loginTime;

    /** 帐号启用状态：0->禁用；1->启用 */
    @ExcelProperty("帐号启用状态")
    private String status;

    /** 假删除：0->删除状态；1->可用状态 */
    @ExcelProperty("删除状态")
    private String del;

}
