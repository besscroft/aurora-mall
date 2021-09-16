package com.besscroft.aurora.mall.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 会员管理模块会员用户信息对象 bms_user_info
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:30
 */
@TableName(value = "bms_user_info")
@ApiModel(value = "会员管理模块会员用户信息对象")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "会员用户信息id", dataType = "Long")
    private Long id;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", dataType = "String")
    private String username;

    /** 密码 */
    @ApiModelProperty(value = "密码", dataType = "String")
    private String password;

    /** 昵称 */
    @ApiModelProperty(value = "昵称", dataType = "String")
    private String nickname;

    /** 手机号码 */
    @ApiModelProperty(value = "手机号码", dataType = "String")
    private String phone;

    /** 帐号启用状态:0->禁用；1->启用 */
    @ApiModelProperty(value = "帐号启用状态", dataType = "Integer")
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private LocalDateTime createTime;

    /** 头像 */
    @ApiModelProperty(value = "头像", dataType = "String")
    private String avatar;

    /** 性别：0->未知；1->男；2->女 */
    @ApiModelProperty(value = "性别", dataType = "Integer")
    private Integer gender;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生日", dataType = "Date")
    private LocalDateTime birthday;

    /** 所在城市 */
    @ApiModelProperty(value = "所在城市", dataType = "String")
    private String city;

    /** 职业 */
    @ApiModelProperty(value = "职业", dataType = "String")
    private String job;

    /** 个性签名 */
    @ApiModelProperty(value = "个性签名", dataType = "String")
    private String personalizedSignature;

    /** 用户注册来源 */
    @ApiModelProperty(value = "用户注册来源", dataType = "Integer")
    private Integer sourceType;

    /** 极光值 */
    @ApiModelProperty(value = "极光值", dataType = "Long")
    private Long auroraPoint;

    /** 极光币 */
    @ApiModelProperty(value = "极光币", dataType = "Long")
    private Long auroraBit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Long getAuroraPoint() {
        return auroraPoint;
    }

    public void setAuroraPoint(Long auroraPoint) {
        this.auroraPoint = auroraPoint;
    }

    public Long getAuroraBit() {
        return auroraBit;
    }

    public void setAuroraBit(Long auroraBit) {
        this.auroraBit = auroraBit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("nickname", getNickname())
                .append("phone", getPhone())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("avatar", getAvatar())
                .append("gender", getGender())
                .append("birthday", getBirthday())
                .append("city", getCity())
                .append("job", getJob())
                .append("personalizedSignature", getPersonalizedSignature())
                .append("sourceType", getSourceType())
                .append("auroraPoint", getAuroraPoint())
                .append("auroraBit", getAuroraBit())
                .toString();
    }

}
