package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //查询菜单 a
    @RequestMapping("/findMenu")
    public @ResponseBody
    List<Menu> findMenu(){
        List<Menu> lists = menuService.quaryMenu();
        return lists;
    }
}
