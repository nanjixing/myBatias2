package com.bjsxt.mapper;

import com.bjsxt.entity.Flower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowerMapper {

    //查询所有操作
    List<Flower>  selectAll();

    //修改操作
    int   insert(Flower  flower);

    //查询操作
    // map.put('param1',1)  map.put('param2','玫瑰花')
    Flower  selectOne(int  id,String  name);

    //map.put('uu',1)  map.put('yy','玫瑰花')
    Flower  selectOne2(@Param("uu") int  id,@Param("yy") String  name);

    //传递对象
    Flower  selectOne3(Flower  flower);

    //传递多个对象
    Flower   selectOne4(Flower  f1,Flower  f2);









}
