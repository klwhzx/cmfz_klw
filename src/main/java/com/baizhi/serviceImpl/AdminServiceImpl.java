package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findAdmin(String del, String password) {
        Admin login = adminDao.queryAdmin(del, password);
        if (login!=null){
            return login;
        }
        return null;
    }

    @Override
    public void motifyPassword(Admin admin) {
        adminDao.updatePassword(admin);
    }
}
