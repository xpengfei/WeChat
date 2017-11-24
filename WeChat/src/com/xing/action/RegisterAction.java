package com.xing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xing.dao.User_info_Dao;
import com.xing.domain.User_info;
import com.xing.util.EncryptByMD5Util;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * Created by xpengfei on 2017/9/22.
 * 注册的Action类
 */
public class RegisterAction extends ActionSupport{
    private User_info user=new User_info();
    private String accountType;
    private String nickname;
    private String account;
    private String sex;
    private String password;
    private String repassword;
    private String phone;
    private String image;
    private String signature;

    public User_info getUser() {
        return user;
    }

    public void setUser(User_info user) {
        this.user = user;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String execute()throws Exception{
        //将数据存到user对象中
        user.setAccount_type(accountType);
        user.setAccount(account);
        user.setNickname(nickname);
        System.out.println("RegisterAction中加密前密码:"+password);
        //将密码进行MD5加密后进行存储
        password= EncryptByMD5Util.getMD5Password(password);
        System.out.println("RegisterAction中加密后密码:"+password);
        user.setPassword(password);
        user.setSex(sex);
        user.setPhone(phone);
        user.setImage(image);
        user.setSignature(signature);
        user.setCreate_time(new Date());
//        //获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        User_info_Dao userDao=session.getMapper(User_info_Dao.class);
        System.out.println("user对象信息:"+user);
//        //插入对象
        userDao.add_user(user);
        //提交事务
        session.commit();
        session.close();
        return "registerSuccess";
    }
}
