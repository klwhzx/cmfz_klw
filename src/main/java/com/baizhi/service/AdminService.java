package com.baizhi.service;


import com.baizhi.entity.Admin;

public interface AdminService {

    //管理员登录
    Admin findAdmin(String del, String password);

    //修改密码
    void motifyPassword(Admin admin);
}
