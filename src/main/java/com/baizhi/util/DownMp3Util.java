package com.baizhi.util;

import org.apache.commons.io.IOUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

public class DownMp3Util {
    public void mp3Size(String title,String openStyle,String path){
        System.out.println(title);
        System.out.println(openStyle);
        System.out.println(path);
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        //根据文件名去服务器中指定目录读取文件
        try {
            String realPath = request.getSession().getServletContext().getRealPath(path);
            //以文件输入流读取文件
            FileInputStream is = new FileInputStream(new File(realPath,title));
            //设置响应头
            response.setHeader("content-disposition", openStyle+";title="+URLEncoder.encode(title,"UTF-8"));
            //获取响应流输出
            ServletOutputStream os = response.getOutputStream();
            //使用IOUtils工具类
            IOUtils.copy(is, os);
            //关闭流
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
