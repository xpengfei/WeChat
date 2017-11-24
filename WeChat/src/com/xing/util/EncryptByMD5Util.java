package com.xing.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xpengfei on 2017/10/1.
 * 工具类,对密码进行MD5加密处理
 */
public class EncryptByMD5Util{
    public static String getMD5Password(String password){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            byte[]bytes=messageDigest.digest(password.getBytes());
            StringBuilder stringBuilder=new StringBuilder(40);
            for (byte b:bytes){
                if ((b&0xff)>>4==0){
                    stringBuilder.append("0").append(Integer.toHexString(b&0xff));
                }else{
                    stringBuilder.append(Integer.toHexString(b&0xff));
                }
            }
            //获取经过MD5加密后的密码
            password=stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}
