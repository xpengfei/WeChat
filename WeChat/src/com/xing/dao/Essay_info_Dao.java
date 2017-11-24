package com.xing.dao;

import com.xing.domain.Essay_info;

import java.util.List;

/**
 * Created by xpengfei on 2017/9/22.
 * 对文章信息表中数据进行操作的接口
 */
public interface Essay_info_Dao {
    //发布文章
    public void add_essay(Essay_info essayInfo);
    //根据公众号id查询公众号的所有文章
    public List<Essay_info> getAllEssayById(int id);
    //根据文章id查看对应的文章信息
    public Essay_info getEssayById(int id);
}
