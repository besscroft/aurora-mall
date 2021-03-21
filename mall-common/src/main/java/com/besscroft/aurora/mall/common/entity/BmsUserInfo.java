package com.besscroft.aurora.mall.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员管理模块会员用户信息对象 bms_user_info
 *
 * @Author Besscroft
 * @Date 2021/1/22 21:30
 */
public class BmsUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 昵称 */
    private String nickname;

    /** 手机号码 */
    private String phone;

    /** 帐号启用状态:0->禁用；1->启用 */
    private Integer status;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 头像 */
    private String avatar;

    /** 性别：0->未知；1->男；2->女 */
    private Integer gender;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /** 所在城市 */
    private String city;

    /** 职业 */
    private String job;

    /** 个性签名 */
    private String personalizedSignature;

    /** 用户注册来源 */
    private Integer sourceType;

    /** 极光值 */
    private Long auroraPoint;

    /** 极光币 */
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
