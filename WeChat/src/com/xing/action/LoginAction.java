package com.xing.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xing.domain.User_info;
import com.xing.service.LoginCheckService;

/**
 * Created by xpengfei on 2017/9/22.
 * 登录Action类,处理登录请求
 */
public class LoginAction extends ActionSupport{
    private String accountType;
    private String account;
    private String password;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //登录,登录成功后将用户的id存入session中国
    public String login(){
        User_info user= LoginCheckService.getUser(accountType,account,password);
        if (user!=null){
            //将查找到的user对象存到session中
            ActionContext actionContext=ActionContext.getContext();
            actionContext.getSession().put("user",user);
            if(accountType.equals("common"))
                return SUCCESS; //普通用户登陆成功
            else
                return "success2";  //公众号用户登陆成功
        }
        else{
            //查询无果,提示账号或密码错误
            ActionContext actionContext=ActionContext.getContext();
            actionContext.getSession().put("error","账号或密码错误!");
            return INPUT;
        }
    }
    //注销,将session中的id去除,并返回登录页面
    public String logout(){
        return INPUT;
    }
}
