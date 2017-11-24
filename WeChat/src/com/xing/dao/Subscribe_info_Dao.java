package com.xing.dao;

import com.xing.domain.User_info;

import java.util.List;

/**
 * Created by xpengfei on 2017/9/22.
 * 对订阅号信息表中数据进行操作的接口
 */
public interface Subscribe_info_Dao {
    //通过用户id获取用户订阅的公众号的列表
    public List<User_info> getSub_Info(int id);
    //通过用户id获取用户未订阅的公众号的列表
    public List<User_info> getUnSub_Info(int id);
}
