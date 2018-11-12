package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //管理员登录
    @RequestMapping("/login")
    public String login(String tel, String password, HttpServletRequest request,String enCode){
        Admin login = adminService.findAdmin(tel, password);
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("validationCode");
        if(code.equals(enCode)) {
            if (login != null) {
                session.setAttribute("login", login);
                return "redirect:/back/main/main.jsp";
            } else {
                return "/back/login";
            }
        }else {
            return "/back/login";
        }
    }

    //管理员修改密码
    @RequestMapping("/updatePassword")
    public @ResponseBody
    Map<String,Object> updatePassword(Admin admin){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            adminService.motifyPassword(admin);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //管理员退出
    @RequestMapping("/esc")
    public String esc(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/back/login.jsp";
    }

}
