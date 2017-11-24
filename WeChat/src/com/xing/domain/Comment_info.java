package com.xing.domain;

import java.io.Serializable;

/**
 * Comment表实体类
 */
public class Comment_info implements Serializable{
  private int id;
  private int essay_id;
  private String comment;
  private java.sql.Timestamp comment_time;
  private String praise;
  private String reply_content;
  private java.sql.Timestamp reply_time;
  private int userId;  //评论者的id信息
  public Comment_info() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEssay_id() {
    return essay_id;
  }

  public void setEssay_id(int essay_id) {
    this.essay_id = essay_id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public java.sql.Timestamp getComment_time() {
    return comment_time;
  }

  public void setComment_time(java.sql.Timestamp comment_time) {
    this.comment_time = comment_time;
  }

  public String getPraise() {
    return praise;
  }

  public void setPraise(String praise) {
    this.praise = praise;
  }

  public String getReply_content() {
    return reply_content;
  }

  public void setReply_content(String reply_content) {
    this.reply_content = reply_content;
  }

  public java.sql.Timestamp getReply_time() {
    return reply_time;
  }

  public void setReply_time(java.sql.Timestamp reply_time) {
    this.reply_time = reply_time;
  }



  @Override
  public String toString() {
    return "Comment_info{" +
            "id=" + id +
            ", essay_id=" + essay_id +
            ", comment='" + comment + '\'' +
            ", comment_time=" + comment_time +
            ", praise='" + praise + '\'' +
            ", reply_content='" + reply_content + '\'' +
            ", reply_time=" + reply_time +
            ", userId=" + userId +
            '}';
  }
}
