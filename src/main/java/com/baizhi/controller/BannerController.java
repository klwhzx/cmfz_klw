package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
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
@RequestMapping("/banner")
public class BannerController {

    private Map<String,Object> map = new HashMap<String,Object>();
    private ImgUtil imgUtil = new ImgUtil();
    @Autowired
    private BannerService bannerService;

    //查询轮播图
    @RequestMapping("/findBanner")
    public @ResponseBody
    List<Banner> findBanner(){
        List<Banner> list = bannerService.quaryBanner();
        return list;
    }

    //删除轮播图
    @RequestMapping("/deleteImp")
    public @ResponseBody Map<String,Object> deleteImp(String id){
        try {
            bannerService.removeImg(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    //批量删除轮播图
    @RequestMapping("/deletesImp")
    public @ResponseBody Map<String,Object> deletesImp(String[] id){
        try {
            for (String s : id) {
                bannerService.removeImg(s);
            }
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    //添加轮播图
    @RequestMapping("/addImp")
    public @ResponseBody
    Map<String,Object> addImp(Banner banner, MultipartFile imgs){
        try {
            imgUtil.uploadImg(imgs,"/back/xgtp/bannerImg");
            bannerService.addImg(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    //修改轮播图
    @RequestMapping("/updateImp")
    public @ResponseBody Map<String,Object> updateImp(Banner banner,MultipartFile imgs){
        try {
            System.out.println(banner);
            bannerService.updateImg(banner);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",true);
            map.put("message",e.getMessage());
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
