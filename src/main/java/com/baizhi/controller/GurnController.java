package com.baizhi.controller;

import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import com.baizhi.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gurn")
public class GurnController {

    private Map<String,Object> map = new HashMap<String, Object>();
    private ImgUtil imgUtil = new ImgUtil();

    @Autowired
    private GurnService gurnService;


    //查询上师
    @RequestMapping("/findGurn")
    public @ResponseBody
    List<Gurn> findGurn(){
        List<Gurn> list = gurnService.quaryGurn();
        return list;
    }

    //添加上师
    @RequestMapping("/addGurn")
    public @ResponseBody Map<String,Object> addGurn(Gurn gurn, MultipartFile imgs){
        try {
            imgUtil.uploadImg(imgs,"/back/xgtp/gurnImg");
            gurnService.addGurn(gurn);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //删除上师
    @RequestMapping("/deleteGurn")
    public @ResponseBody Map<String,Object> deleteGurn(String id){
        try {
            gurnService.removeGurn(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //批量删除上师
    @RequestMapping("/deleteGurns")
    public @ResponseBody Map<String,Object> deleteGurns(String[] id){
        try {
            for (String s : id) {
                gurnService.removeGurn(s);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //修改上师
    @RequestMapping("/updateGurn")
    public @ResponseBody Map<String,Object> updateGurn(Gurn gurn){
        try {
            gurnService.updateGurn(gurn);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }


    public ImgUtil getImgUtil() {
        return imgUtil;
    }

    public void setImgUtil(ImgUtil imgUtil) {
        this.imgUtil = imgUtil;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
