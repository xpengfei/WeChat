package com.xing.domain;


import java.io.Serializable;

/**
 * Essay表实体类
 */
public class Essay_info implements Serializable {
  private int id;
  private String title;
  private String content;
  private int praise;
  private int browse;
  private int puserId;//公众号的id

  public Essay_info() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

  public int getPraise() {
    return praise;
  }

  public void setPraise(int praise) {
    this.praise = praise;
  }

  public int getBrowse() {
    return browse;
  }

  public void setBrowse(int browse) {
    this.browse = browse;
  }

  public int getPuserId() {
    return puserId;
  }

  public void setPuserId(int puserId) {
    this.puserId = puserId;
  }
  @Override
  public String toString() {
    return "Essay_info{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", praise='" + praise + '\'' +
            ", browse='" + browse + '\'' +
            ", userId=" + puserId +
            '}';
  }
}
