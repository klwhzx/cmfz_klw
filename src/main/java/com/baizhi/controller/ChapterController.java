package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import com.baizhi.util.DownMp3Util;
import com.baizhi.util.DurationMp3Util;
import com.baizhi.util.Mp3SizeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {

    private Map<String,Object> map = new HashMap<String, Object>();


    @Autowired
    private ChapterService chapterService;

    //查询音频
    @RequestMapping("/findAll")
    public List<Chapter> findAll(){
        List<Chapter> chapters = chapterService.findAll();
        return chapters;
    }

    //上传音频
    @RequestMapping("/addyp")
    public @ResponseBody
    Map<String,Object> addyp(Chapter chapter, MultipartFile mp3, HttpServletRequest request){
        Mp3SizeUtil mp3SizeUtil = new Mp3SizeUtil();
        DurationMp3Util durationMp3Util = new DurationMp3Util();
        try {
            String realPath = request.getRealPath("/back/chapter");
            File file = new File(realPath,mp3.getOriginalFilename());
            mp3.transferTo(file);
            //获取音频大小
            String mp3Size = mp3SizeUtil.voMp3Size(file);
            //获取音频时长
            String durarion = durationMp3Util.voMp3Durarion(file);
            chapter.setSize(mp3Size);
            chapter.setDuration(durarion);
            chapterService.add(chapter);
            map.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }

    //下载音频
    @RequestMapping("/downMp3")
    public @ResponseBody Map<String,Object> downMp3(String title){
        System.out.println(title);
        try {
            DownMp3Util downMp3Util = new DownMp3Util();
            downMp3Util.mp3Size(title,null,"/back/chapter");
            map.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("massage",e.getMessage());
        }
        return map;
    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
