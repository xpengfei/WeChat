package com.xing.test.subinfo_test;

import com.xing.dao.Subscribe_info_Dao;
import com.xing.domain.User_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpengfei on 2017/11/19.
 */
public class TestSubInfo {
    @Test
    public void TestSubInfo(){
        List<User_info>list=new ArrayList<>();
        //存储订阅公众号的对象信息
        List<User_info>userSubList=new ArrayList<>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
//        User_info_Dao userDao=session.getMapper(User_info_Dao.class);
        Subscribe_info_Dao subscribeInfoDao=session.getMapper(Subscribe_info_Dao.class);
        //获取当前登陆的用户的对象信息,以便获取其id
//        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        //调用方法,查找订阅的公众号的信息,,,,,这里的参数类型是long
        userSubList=subscribeInfoDao.getSub_Info(8);
        for (User_info u:userSubList){
            System.out.println(u.toString());
        }
    }
    @Test
    public void testUnSubInfo(){
        List<User_info>list=new ArrayList<>();
        //存储订阅公众号的对象信息
        List<User_info>userSubList=new ArrayList<User_info>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
//        User_info_Dao userDao=session.getMapper(User_info_Dao.class);
        Subscribe_info_Dao subscribeInfoDao=session.getMapper(Subscribe_info_Dao.class);
        //获取当前登陆的用户的对象信息,以便获取其id
//        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        //调用方法,查找订阅的公众号的信息,,,,,这里的参数类型是long
        userSubList=subscribeInfoDao.getUnSub_Info(8);
        for (User_info u:userSubList){
            System.out.println(u.toString());
        }
    }
}
