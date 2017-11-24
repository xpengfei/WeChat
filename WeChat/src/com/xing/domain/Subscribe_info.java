package com.xing.domain;

import java.io.Serializable;

/**
 * Subscribe表实体类
 */
public class Subscribe_info implements Serializable{
  private int id;
  private int user_id;
  private int subscribe_id;

  public Subscribe_info() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getSubscribe_id() {
    return subscribe_id;
  }

  public void setSubscribe_id(int subscribe_id) {
    this.subscribe_id = subscribe_id;
  }

  @Override
  public String toString() {
    return "Subscribe_info{" +
            "id=" + id +
            ", user_id=" + user_id +
            ", subscribe_id=" + subscribe_id +
            '}';
  }
}
