package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {


    //增加
        void insert(T t);

    //    删除
    void delete(String t);
    //    修改
    void update(T t);
    //    查询所有
    List<T> queryAll();

    //查询分页
    //参数1:起始条数 //参数2:每页显示的记录数
    List<T> queryByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //根据id查询
    T queryById(String t);

    //查询总条数
    Long queryTotals();
}
