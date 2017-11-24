package com.xing.dao;

import com.xing.domain.User_info;

/**
 * Created by xpengfei on 2017/9/22.
 * 对用户信息表中的数据进行操作的接口
 */
public interface User_info_Dao {
    //添加用户,注册时调用的方法
    public void add_user(User_info user);
    //登录时调用的方法,获取用户的信息，登录成功后,将用户对象存入session
    public User_info check_login(String accountType,String account,String password);

}
