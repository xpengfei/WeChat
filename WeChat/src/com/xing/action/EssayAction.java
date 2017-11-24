package com.xing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xing.dao.Essay_info_Dao;
import com.xing.domain.Essay_info;
import com.xing.util.GenerateSqlSession;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xpengfei on 2017/10/12.
 */
public class EssayAction extends ActionSupport {
    private String title;
    private String content;
    private int  puserId;
    private Essay_info essayInfo=new Essay_info();
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Essay_info getEssayInfo() {
        return essayInfo;
    }
    public void setEssayInfo(Essay_info essayInfo) {
        this.essayInfo = essayInfo;
    }

    public int getPuserId() {
        return puserId;
    }

    public void setPuserId(int puserId) {
        this.puserId = puserId;
    }

    public String add_essay(){
        //获取SqlSession
        SqlSession session= GenerateSqlSession.getSqlSession();
        Essay_info_Dao essay_info_dao=session.getMapper(Essay_info_Dao.class);
        //设置title以及content
        essayInfo.setTitle(title);
        essayInfo.setContent(content);
        essayInfo.setPuserId(puserId);
        System.out.println("title:"+title+"\tcontent:"+content);
        essay_info_dao.add_essay(essayInfo);
        System.out.println(essayInfo);
        session.commit();
        session.close();
        return SUCCESS;
    }
}
