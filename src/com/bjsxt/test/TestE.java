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

public class TestE {

    public static void main(String[] args) throws IOException {

        //[1]解析myBatis.xml文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

        //[2]获得sqlsession工厂
        SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(inputStream);

        //[3]获得session对象
        SqlSession sqlSession = factory.openSession(true);

        //[4]执行方法
        //mapper动态代理方式1
        FlowerMapper mapper = sqlSession.getMapper(FlowerMapper.class);

        Flower flower = mapper.selectOne(1, "玫瑰花");//这里就是任意参数的传递了

        System.out.println(flower);

        //[5]关闭资源
        sqlSession.close();

    }
}

/**这种注释生成方法是快捷键明加tab键
 * @description
 * @author admin
 * @updateTime 2021/3/19 15:33
 */


