package com.xing.test.essay_info;

import com.xing.dao.Essay_info_Dao;
import com.xing.domain.Essay_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpengfei on 2017/11/19.
 */
public class TestGetEssay {
    @Test
    public void testGetEssayInfo(){
        //存储发布的文章对象
        List<Essay_info>essayList=new ArrayList<>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Essay_info_Dao essay_info_dao=session.getMapper(Essay_info_Dao.class);
        //获取公众号的id信息,进行相应的查询
//        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        //调用方法,查找订阅的公众号的信息,,,,,这里的参数类型是int
        essayList=essay_info_dao.getAllEssayById(9);
        for (Essay_info essay:essayList){
            System.out.println(essay.toString());
        }
    }
    @Test
    public void getEssay(){
        Essay_info essayInfo=new Essay_info();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Essay_info_Dao essay_info_dao=session.getMapper(Essay_info_Dao.class);
        //获取公众号的id信息,进行相应的查询
//        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        //调用方法,查找订阅的公众号的信息,,,,,这里的参数类型是int
       essayInfo=essay_info_dao.getEssayById(33);
        System.out.println(essayInfo);
    }
}
