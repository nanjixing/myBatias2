package com.bjsxt.test;

import com.bjsxt.entity.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestC {

    public static void main(String[] args) throws IOException {

        //[1]解析myBatis.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        //[2]获得sqlsession工厂
        SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(inputStream);

        //[3]获得session对象
        SqlSession sqlSession = factory.openSession(true);

        //[4]执行方法

        Flower  f=new Flower();
        f.setName("玫瑰花");
        f.setPrice(52);


        //【A】添加的操作
        int insert = sqlSession.insert("com.bjsxt.mapper.FlowerMapper3.insert", f);


        //【B】修改操作
        //int update = sqlSession.update("com.bjsxt.mapper.FlowerMapper3.update", f);

        //【C】删除操作
//        int delete = sqlSession.delete("com.bjsxt.mapper.FlowerMapper3.delete", 8);


        //[5]关闭资源
        sqlSession.close();

    }

}

/*
/**
 * @description 出现的问题是MySQL的默认事务处理方式有两种解决方法
 * @author admin
 * @updateTime 2021/3/19 14:42
 */
/*   添加  、删除  修改操作写好了必须提交
*
*     [A]sqlSession.commit();
*
*     [B]SqlSession sqlSession = factory.openSession(true);
*
*
*   parameterType :参数的类型可以省去的。增删改查和参数传递都可以不写可以自动判断
*
* <!--arg0 :代表的是下标为0 的参数-->
          <!-- DELETE   from  flower  WHERE   id=#{arg0} -->
* */
