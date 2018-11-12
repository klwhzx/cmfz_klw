package com.baizhi.serviceImpl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        user.setImg("/back/from/user/"+user.getImg());
        user.setS_date(new Date());
        userDao.insert(user);
    }

    @Override
    public void updateUser(User user) {
        user.setImg("/back/from/user/"+user.getImg());
        user.setS_date(new Date());
        userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findPassword(String tel, String password) {
        User users = userDao.queryPassword(tel, password);
        return users;
    }
}
