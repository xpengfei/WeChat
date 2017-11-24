package com.xing.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xing.domain.PublicContent;

import java.util.List;

/**
 * Created by xpengfei on 2017/10/7.
 *
 */
public class GetPublicAction extends ActionSupport {
    private List<PublicContent>userlist;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<PublicContent> getUserlist() {
        return userlist;
    }
    public void setUserlist(List<PublicContent> userlist) {
        this.userlist = userlist;
    }



    public String getSubPublic(){

        PublicContent user=new PublicContent();
        user.setNickname("xing");
        user.setSignature("测试数据");
        userlist.add(user);

        //将要返回的实体对象进行json处理


        //测试输出

        return "subPublic";
    }

    public String getUnsubPublic(){

        return "unsubPublic";
    }
}
