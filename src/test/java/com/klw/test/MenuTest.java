package com.klw.test;


import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class MenuTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void test1(){
        List<Menu> list = menuService.quaryMenu();
        for (Menu menu : list) {
            System.out.println(menu);
        }
    }

}
