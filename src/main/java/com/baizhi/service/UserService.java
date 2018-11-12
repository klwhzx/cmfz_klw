package com.baizhi.service;

import com.baizhi.entity.User;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    User findPassword(String tel,String password);
}
