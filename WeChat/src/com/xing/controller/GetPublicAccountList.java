package com.xing.controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.dao.Subscribe_info_Dao;
import com.xing.domain.User_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by xpengfei on 2017/11/18.
 * 获取公众号列表
 */
public class GetPublicAccountList {
    /**
     * 用户登陆后.用户的信息存储在session中,根据用户id可以查找到订阅的公众号的id
     * 以及未订阅的公众号的id信息,根据公众号的id可以查到公众号的相关信息,将对应的
     * 公众号对象信息存储到List中,在前端jsp中展示出来
     */
     public String getSub(){
        //存储订阅公众号的对象信息
        List<User_info>userSubList=new ArrayList<User_info>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
//        User_info_Dao userDao=session.getMapper(User_info_Dao.class);
        Subscribe_info_Dao subscribeInfoDao=session.getMapper(Subscribe_info_Dao.class);
        //获取当前登陆的用户的对象信息,以便获取其id
        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        //调用方法,查找订阅的公众号的信息,,,,,这里的参数类型是int
         userSubList=subscribeInfoDao.getSub_Info(user.getId());
         ActionContext.getContext().put("userSubList",userSubList);
         return SUCCESS;
    }
    public String getUnSub(){
        //存储未订阅公众号的对象信息
        List<User_info>userUnSubList=new ArrayList<User_info>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Subscribe_info_Dao subscribeInfoDao=session.getMapper(Subscribe_info_Dao.class);
        //获取当前登陆的用户的对象信息,以便获取其id
        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        //调用方法,查找未订阅的公众号的信息,,,,,这里的参数类型是long
        userUnSubList=subscribeInfoDao.getUnSub_Info(user.getId());
        ActionContext.getContext().put("userUnSubList",userUnSubList);
        return SUCCESS;
    }
}
