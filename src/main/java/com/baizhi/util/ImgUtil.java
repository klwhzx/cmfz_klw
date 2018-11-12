package com.baizhi.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class ImgUtil {

    public void uploadImg(MultipartFile imgs, String path){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String realPath = request.getRealPath(path);
        try {
            imgs.transferTo(new File(realPath,imgs.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
