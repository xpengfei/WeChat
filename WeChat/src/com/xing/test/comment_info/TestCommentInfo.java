package com.xing.test.comment_info;

import com.xing.dao.Comment_info_Dao;
import com.xing.domain.Comment_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xpengfei on 2017/11/23.
 */
public class TestCommentInfo {
    @Test
    public void testAddComment(){
        //存储评论的相关信息至评论对象
        Comment_info commentInfo=new Comment_info();
        //获取请求中的文章id
//        String essayId= ServletActionContext.getRequest().getParameter("essayId");
//        int essayid=Integer.parseInt(essayId);
        commentInfo.setEssay_id(33);
        //获取评论内容
//        String comment= ServletActionContext.getRequest().getParameter("UserComment");
        commentInfo.setComment("评论信息的测试数据!!!!");
        //获取当前时间,作为评论时间
        Date date=new Date();
        Timestamp comment_time=new Timestamp(date.getTime());
        commentInfo.setComment_time(comment_time);
        //获取用户的id进行存储
//        String puserId= ServletActionContext.getRequest().getParameter("puserId");
//        int userId =Integer.parseInt(puserId);
        commentInfo.setUserId(8);

        //        //获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Comment_info_Dao commentInfoDao=session.getMapper(Comment_info_Dao.class);
        commentInfoDao.add_comment(commentInfo);
        //提交事务
        session.commit();
        session.close();
    }
}
