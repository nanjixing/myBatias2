package com.bjsxt.test;

import com.bjsxt.entity.Flower;
import com.bjsxt.mapper.FlowerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestD {

    public static void main(String[] args) throws IOException {

        //[1]解析myBatis.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        //[2]获得sqlsession工厂
        SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(inputStream);

        //[3]获得session对象
        SqlSession sqlSession = factory.openSession(true);

        //[4]执行方法

        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);

        //查询操作
        List<Flower> list = mapper.selectAll();

        //添加操作
        Flower  f=new Flower();
        f.setName("sxt");
        f.setPrice(19);
        f.setProduction("bj");
        int insert = mapper.insert(f);

        System.out.println(insert);

        //[5]关闭资源
        sqlSession.close();

    }

}


