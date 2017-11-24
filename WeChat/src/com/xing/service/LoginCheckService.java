package com.xing.service;

import com.xing.dao.User_info_Dao;
import com.xing.domain.User_info;
import com.xing.util.EncryptByMD5Util;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServlet;

/**
 * Created by xpengfei on 2017/10/1.
 * 登录服务类
 */
public class LoginCheckService extends HttpServlet{
    public static User_info getUser(String accountType, String account,String password){
        //获取SqlSession对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        User_info_Dao userDao=session.getMapper(User_info_Dao.class);
        //密码是进行MD5加密后存储的,所以要对登录时的密码进行MD5加密,才能匹配
        System.out.println("getUser中加密前密码:"+password);
        password= EncryptByMD5Util.getMD5Password(password);
        System.out.println("getUser中加后前密码:"+password);
        //用User_info对象接收查询返回结果
        User_info user=new User_info();
        System.out.println("getUser方法查询之前的对象:"+user);
        user=userDao.check_login(accountType,account,password);
        System.out.println("getUser方法查询之后的对象:"+user);
        session.commit();
        session.close();
        return user;
    }
}
