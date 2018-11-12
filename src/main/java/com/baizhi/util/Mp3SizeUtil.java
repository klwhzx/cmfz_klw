package com.baizhi.util;

import java.io.File;
import java.text.DecimalFormat;

public class Mp3SizeUtil {

    public String voMp3Size(File file){
        DecimalFormat df = new DecimalFormat("#.00");
        long mmm = file.length();
        String mp3Size="";
        if (mmm < 1024) {
            mp3Size = df.format((double) mmm) + "B";
        } else if (mmm < 1048576) {
            mp3Size = df.format((double) mmm / 1024) + "K";
        } else if (mmm < 1073741824) {
            mp3Size = df.format((double) mmm / 1048576) + "M";
        } else {
            mp3Size = df.format((double) mmm / 1073741824) + "G";
        }
        return mp3Size;
    }
}
