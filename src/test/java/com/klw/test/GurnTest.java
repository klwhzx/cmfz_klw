package com.klw.test;


import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GurnTest {

    @Autowired
    private GurnService gurnService;

    @Test
    public void test1(){
        List<Gurn> gurns = gurnService.quaryGurn();
        for (Gurn gurn : gurns) {
            System.out.println(gurn);
        }
    }

}
