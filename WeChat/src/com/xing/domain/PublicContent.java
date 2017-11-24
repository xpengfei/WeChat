package com.xing.domain;

import java.io.Serializable;

/**
 * Created by xpengfei on 2017/10/7.
 * 用于传递公众号名称以及描述
 */
public class PublicContent implements Serializable{
    private String nickname;
    private String signature;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
