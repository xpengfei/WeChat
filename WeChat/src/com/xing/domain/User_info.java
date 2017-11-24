package com.xing.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * User表实体类
 */
public class User_info implements Serializable{
  private int id;
  private String account_type;//账户类型
  private String nickname;//昵称
  private String image;//头像
  private String account;//账号
  private String password;//密码
  private String phone;//电话
  private String sex;//性别
  private String signature;//签名
  private Date create_time;//注册时间
//  private Subscribe_info sub_info;//存储普通用户与公众号之间映射关系

  public User_info() {
  }

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAccount_type() {
    return account_type;
  }

  public void setAccount_type(String account_type) {
    this.account_type = account_type;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

//  public Subscribe_info getSub_info() {
//    return sub_info;
//  }
//
//  public void setSub_info(Subscribe_info sub_info) {
//    this.sub_info = sub_info;
//  }

  @Override
  public String toString() {
    return "User_info{" +
            "id=" + id +
            ", account_type='" + account_type + '\'' +
            ", nickname='" + nickname + '\'' +
            ", image='" + image + '\'' +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", phone='" + phone + '\'' +
            ", sex='" + sex + '\'' +
            ", signature='" + signature + '\'' +
            ", create_time=" + create_time +
//            ", sub_info=" + sub_info +
            '}';
  }
}
