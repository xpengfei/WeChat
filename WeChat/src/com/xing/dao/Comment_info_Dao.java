package com.xing.dao;

import com.xing.domain.Comment_info;

import java.util.List;

/**
 * Created by xpengfei on 2017/9/22.
 * comment评论表接口,声明对评论表操作的各种方法
 */
//对评论信息表中数据进行操作的接口
public interface Comment_info_Dao {
    //添加文章评论的相关信息
    public void add_comment(Comment_info commentInfo);
    //通过文章id,获取该文章的所有评论信息
    public List<Comment_info> get_comment_ByEssayId(int essay_id);
    //通过用户的id,获取用户写过的所有评论信息
    public List<Comment_info> getComment_ByUserId(int userId);
    //通过公众号的ID,获取其发布过的文章的id,根据文章ID获取所有的评论信息
    public List<Comment_info> getComment_ByPUserId(int puserId);
}
