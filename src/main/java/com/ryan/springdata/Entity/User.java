package com.ryan.springdata.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "name",nullable = true)
    private String name;

    /**
     * 手机号
     */
    @Column(nullable = true)
    private String phone;

    /**
     * 电子邮件
     */
    @Column(nullable = true)
    private String email;

    /**
     * 自我介绍
     */
    @Column(nullable = true)
    private String aboutme;

    /**
     * 经过md5加密的密码
     */
    @Column(nullable = true)
    private String passwd;

    /**
     * 头像图片
     */
    @Column(nullable = true)
    private String avatar;

    /**
     * 1:普通用户，2:房产经纪人
     */
    @Column(nullable = true)
    private Byte type;

    /**
     * 创建时间
     */
    @Column(nullable = true)
    private Date createTime;

    /**
     * 是否启用1：启用，0：停用
     */
    @Column(nullable = true)
    private Byte enable;

    /**
     * 所属经纪机构
     */
    @Column(nullable = true)
    private Integer agencyId;

    @JoinColumn(name="ADDRESS_ID")
    @ManyToOne
    private Address address;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }


    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取电子邮件
     *
     * @return email - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取自我介绍
     *
     * @return aboutme - 自我介绍
     */
    public String getAboutme() {
        return aboutme;
    }

    /**
     * 设置自我介绍
     *
     * @param aboutme 自我介绍
     */
    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    /**
     * 获取经过md5加密的密码
     *
     * @return passwd - 经过md5加密的密码
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 设置经过md5加密的密码
     *
     * @param passwd 经过md5加密的密码
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 获取头像图片
     *
     * @return avatar - 头像图片
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像图片
     *
     * @param avatar 头像图片
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取1:普通用户，2:房产经纪人
     *
     * @return type - 1:普通用户，2:房产经纪人
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置1:普通用户，2:房产经纪人
     *
     * @param type 1:普通用户，2:房产经纪人
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否启用1：启用，0：停用
     *
     * @return enable - 是否启用1：启用，0：停用
     */
    public Byte getEnable() {
        return enable;
    }

    /**
     * 设置是否启用1：启用，0：停用
     *
     * @param enable 是否启用1：启用，0：停用
     */
    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    /**
     * 获取所属经纪机构
     *
     * @return agency_id - 所属经纪机构
     */
    public Integer getAgencyId() {
        return agencyId;
    }

    /**
     * 设置所属经纪机构
     *
     * @param agencyId 所属经纪机构
     */
    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", aboutme='" + aboutme + '\'' +
                ", passwd='" + passwd + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                ", enable=" + enable +
                ", agencyId=" + agencyId +
                ", address=" + address +
                '}';
    }
}