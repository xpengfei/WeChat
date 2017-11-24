package com.xing.controller;

import com.opensymphony.xwork2.ActionContext;
import com.xing.dao.Essay_info_Dao;
import com.xing.domain.Essay_info;
import com.xing.domain.User_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by xpengfei on 2017/11/21.
 * 获取公众号发布的文章
 */
public class GetPuserEssay {
    //根据公众号id获取该公众号发布的文章列表
    public String getAllEssay_ById(){
        List<Essay_info> essayList=new ArrayList<>();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Essay_info_Dao essayInfoDao=session.getMapper(Essay_info_Dao.class);
        //判断当前用户是普通用户还是公众号用户
        User_info userJudge= (User_info) ActionContext.getContext().getSession().get("user");
        int pid=-1;
        if (userJudge.getAccount_type().equals("common")){
           //当前账号是普通用户,获取请求地址中的公众号id
           String puserId= ServletActionContext.getRequest().getParameter("puserId");
           pid =Integer.parseInt(puserId);
       }else{
            //当前账号是公众号,直接获取公众号的id信息
            pid=userJudge.getId();
       }
        //调用方法,查询ID为pid的公众号所发布的文章信息
        essayList=essayInfoDao.getAllEssayById(pid);
        ActionContext.getContext().put("essayList",essayList);
        //提交事务
        session.commit();
        session.close();
        return SUCCESS;
    }
    //根据文章的id获取文章的相关详细信息
    public String getEssay_ById(){
        Essay_info essayInfo=new Essay_info();
        //        获取session对象
        SqlSession session= GenerateSqlSession.getSqlSession();
        Essay_info_Dao essayInfoDao=session.getMapper(Essay_info_Dao.class);
        //获取请求中的文章id
        String essayId= ServletActionContext.getRequest().getParameter("essayId");
        int eid=Integer.parseInt(essayId);
        essayInfo=essayInfoDao.getEssayById(eid);
        ServletActionContext.getRequest().setAttribute("essayInfo",essayInfo);
        return SUCCESS;
    }
}
