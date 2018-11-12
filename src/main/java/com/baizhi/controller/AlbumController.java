package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {

    private Map<String,Object> map = new HashMap<String, Object>();
    private ImgUtil imgUtil = new ImgUtil();

    @Autowired
    private AlbumService albumService;

    //展示全部专辑
    @RequestMapping("/findAll")
    public @ResponseBody
    List<Album> findAll(){
        List<Album> list = albumService.findAll();
        return list;
    }


    //查询所有专辑和专辑内章节
    @RequestMapping("/findTwo")
    public @ResponseBody
    List<Album> findTwo(){
        List<Album> list = albumService.findTwo();
        return list;
    }

    //根据id查询专辑
    @RequestMapping("/findById")
    public @ResponseBody
    Album findById(String id){
        Album albums = albumService.findById(id);
        return albums;
    }

    //添加专辑
    @RequestMapping("/add")
    public @ResponseBody Map<String,Object> add(Album album, MultipartFile imgs){
        try {
            imgUtil.uploadImg(imgs,"/back/xgtp/albumImg");
            albumService.add(album);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //修改专辑
    @RequestMapping("/update")
    public @ResponseBody
    Map<String,Object> update(Album album,MultipartFile imgs){
        try {
            imgUtil.uploadImg(imgs,"/back/xgtp/albumImg");
            albumService.update(album);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }


    //删除专辑
    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> delete(String id){
        try {
            albumService.remove(id);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //批量删除
    @RequestMapping("/deletes")
    public @ResponseBody Map<String,Object> deletes(String[] id){
        try {
            for (String s : id) {
                albumService.remove(s);
            }
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
