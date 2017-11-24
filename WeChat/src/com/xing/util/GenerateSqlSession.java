package com.xing.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by xpengfei on 2017/9/22.
 * 工具类,生成SqlSessionFactory对象
 */
public class GenerateSqlSession {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        try {
            //读取Mybatis的配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession对象的静态方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //获取SqlSessionFactory对象
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
