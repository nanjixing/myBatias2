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

public class TestB {

    public static void main(String[] args) throws IOException {

        //[1]解析myBatis.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        //[2]获得sqlsession工厂
        SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(inputStream);

        //[3]获得session对象
        SqlSession sqlSession = factory.openSession();

        //[4]执行方法

        //参数传递一   单个参数
//        Flower   flower = sqlSession.selectOne("com.bjsxt.mapper.FlowerMapper2.selectOne", 1);
//        System.out.println(flower);
        //参数传递二 传入对象
//        Flower  f=new Flower();
//        f.setId(1);
//        f.setName("菊花");
//        f.setPrice(20);
//        Flower  flower= sqlSession.selectOne("com.bjsxt.mapper.FlowerMapper2.selectOne2",f);
//        System.out.println(flower);
        //参数传递三  Map集合，如果要在两个表中查询，就不能使用第二种传值方式了,使用map可以方便进行连接查询
        Map<String,Object>  map=new HashMap<>();
        map.put("a",1);
        map.put("b","菊花");
        Flower  flower = sqlSession.selectOne("com.bjsxt.mapper.FlowerMapper2.selectOne3", map);

        System.out.println(flower);

        //[5]关闭资源
        sqlSession.close();

    }

}

/*
* 补充:在FlowerMapper1.xml中也可以使用$,但是这时候打印出来就不是？就是直接的字符串拼接了，不安全。
*   #:底层是使用占位 ？，向占位符传值用#
*
*   $:底层使用的是字符串拼接，属性文件
*
* */
