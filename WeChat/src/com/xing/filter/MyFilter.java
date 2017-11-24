package com.xing.filter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xpengfei on 2017/10/1.
 * 自定义的Filter,对导入的easyui的js和css文件设置为不过滤
 */
public class MyFilter  extends StrutsPrepareAndExecuteFilter{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) req;
        //uri获取的是发给服务器的请求地址
        String uri=request.getRequestURI();
        //不过滤的url
        if(uri.indexOf("/static")!=-1){
            System.out.println("使用自定义的拦截器");
            chain.doFilter(req,res);
        }else{
            System.out.println("使用默认的拦截器");
            super.doFilter(req,res,chain);
        }

    }
}
