package com.bjsxt.test;

import com.bjsxt.entity.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestA {

    public static void main(String[] args) throws IOException {

        //[1]解析myBatis.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        //[2]获得sqlsession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //[3]获得session对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //[4]执行方法

        //[A]查询方式一 适合于结果集返回的是多条数据的时候
//        List<Flower> list = sqlSession.selectList("com.bjsxt.mapper.FlowerMapper1.selectAll");
//        System.out.println(list);

        //[B]查询方式二  查询适用于最多返回是一条结果集数据
//        Flower flower = sqlSession.selectOne("com.bjsxt.mapper.FlowerMapper1.selectOne");
//        System.out.println(flower);
        //[C]查询方式三
        // 作用：希望可以通过数据库中的某一列快速的找到这一列对应的结果集
       // selectMap("调用的方法", "希望数据库的那一列作用key")
        Map<Object, Object> map = sqlSession.selectMap("com.bjsxt.mapper.FlowerMapper1.selectMap", "id");

        System.out.println(map);

        Object flower1 = map.get(1);//map中的key值即id的值,快速找到行

        System.out.println(flower1);

        //[5]关闭资源
        sqlSession.close();

    }

}
