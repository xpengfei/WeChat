package com.xing.test.essay_info;

import com.xing.dao.Essay_info_Dao;
import com.xing.domain.Essay_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xpengfei on 2017/11/21.
 */
public class TestGetEssayList {
    @Test
    public void TestGetEssayList(){
        List<Essay_info> essayList=new ArrayList<>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Essay_info_Dao essayInfoDao=session.getMapper(Essay_info_Dao.class);
        //获取请求地址中的公众号id
//        String puserId= ServletActionContext.getRequest().getParameter("puserId");
//        int pid=Integer.parseInt(puserId);

        //调用方法,查询ID为pid的公众号所发布的文章信息
        essayList=essayInfoDao.getAllEssayById(9);
        for (Essay_info essayInfo:essayList){
            System.out.println(essayInfo.toString());
        }
    }
}
