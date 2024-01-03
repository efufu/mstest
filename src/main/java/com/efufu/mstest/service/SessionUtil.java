package com.efufu.mstest.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionUtil {
    private SqlSessionFactory build;
    private SqlSession session;

    public SessionUtil() {

        InputStream is;
        try {
            is = Resources.getResourceAsStream("mybatis_config.xml");
            build = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void destroy(){
        if(session!=null){
            session.commit();
            session.close();
        }
    }
    //编写一个获取SqlSession的方法
    public SqlSession getSession(){
        if (session == null) {
            session = build.openSession();
        }
        return session;
    }


    public void getIStudent(){
        return ;
    }

    public void getICourse(){
        return ;
    }

}
