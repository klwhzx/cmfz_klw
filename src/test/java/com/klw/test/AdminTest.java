package com.klw.test;


import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void test1(){
        Admin login = adminService.findAdmin("133333333", "kkllww");
        if (login!=null){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }


}
