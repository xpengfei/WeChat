package com.xing.controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.dao.Comment_info_Dao;
import com.xing.domain.Comment_info;
import com.xing.domain.User_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import java.sql.Timestamp;
import java.util.Date;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by xpengfei on 2017/11/23.
 * 提交评论,以及获取文章相应的评论信息的controller
 */
public class CommentController {
    //将essayID存储到Request中,便于提交平理论时使用
    public String add_essay_id(){
        //获取请求中的文章id
        String essayId= ServletActionContext.getRequest().getParameter("essay_id");
        int essay_id=Integer.parseInt(essayId);
        ActionContext.getContext().put("essay_id",essay_id);
        return SUCCESS;
    }

    //添加评论
    public void add_comment(){
        //存储评论的相关信息至评论对象
        Comment_info commentInfo=new Comment_info();
        //获取请求中的文章id
        String essayId= ServletActionContext.getRequest().getParameter("essay_id");
        int essayid=Integer.parseInt(essayId);
        commentInfo.setEssay_id(essayid);
        //获取评论内容
        String comment= ServletActionContext.getRequest().getParameter("UserComment");
       commentInfo.setComment(comment);
        //获取当前时间,作为评论时间
        Date date=new Date();
        Timestamp comment_time=new Timestamp(date.getTime());
        commentInfo.setComment_time(comment_time);
        //获取用户的id进行存储
        User_info user= (User_info) ActionContext.getContext().getSession().get("user");
        commentInfo.setUserId(user.getId());

        //        //获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Comment_info_Dao commentInfoDao=session.getMapper(Comment_info_Dao.class);
        commentInfoDao.add_comment(commentInfo);
        //提交事务
        session.commit();
        session.close();
    }
}
