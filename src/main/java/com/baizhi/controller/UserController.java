package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private Map<String,Object> map = new HashMap<String,Object>();
    private ImgUtil imgUtil = new ImgUtil();

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping("/addUser")
    public @ResponseBody
    Map<String,Object> addUser(User user,MultipartFile imgs){
        try {
            imgUtil.uploadImg(imgs,"/back/xgtp/userImg/");
            userService.addUser(user);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("success",e.getMessage());
        }
        return map;
    }

    //用户修改
    @RequestMapping("/updateUser")
    public @ResponseBody Map<String,Object> updateUser(User user,MultipartFile imgs){
        try {
            imgUtil.uploadImg(imgs,"/back/xgtp/userImg/");
            userService.updateUser(user);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("success",e.getMessage());
        }
        return map;
    }

    //用户登录
    @RequestMapping("/login")
    public String login(String tel, String password, HttpServletRequest request){
        User login = userService.findPassword(tel, password);
        if (login!=null){
            request.setAttribute("lohin",login);
            return "";
        }
        return "";
    }

















    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
