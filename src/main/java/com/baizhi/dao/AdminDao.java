package com.baizhi.dao;


import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao extends BaseDao<Admin> {
    //登录
    Admin queryAdmin(@Param("tel") String tel, @Param("password") String password);

    //修改密码
    void updatePassword(Admin admin);

}
