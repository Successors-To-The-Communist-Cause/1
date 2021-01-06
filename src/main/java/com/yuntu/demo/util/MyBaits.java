package com.yuntu.demo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyBaits {
    public static SqlSessionFactory factory;
    static {//静态代码块 1.项目初运行时最先执行    2.只执行一次  Factroy工厂
        try {
            //1.获取Mybatis-config的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建一个SqlSessionFactory工厂对象
            factory =new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    * 打开sqlsession
    * */
    public static SqlSession createSession(){
        return factory.openSession(false);//3.根据工厂创建SqlSession工具(执行Mapper) true自动提交
    }
    /*
    * 关闭sqlsession
    * */
    public static void closeSQLSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }
}
