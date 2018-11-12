package com.baizhi.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;

public class DurationMp3Util {

    public String voMp3Durarion(File file) {
        try {
                MP3File f = (MP3File) AudioFileIO.read(file);
                MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
                int min = audioHeader.getTrackLength();
                String duration = "";
                if (min < 60) {
                    if (min < 10) {
                        duration = "00:" + "0" + min;
                    } else {
                        duration = "00:" + min;
                    }
                } else {
                    int b = min / 60;
                    int c = min - ((min / 60) * 60);
                    if (b < 10 && c < 10) {
                        duration = "0" + b + ":" + "0" + c;
                    } else if (b < 10 && c > 10) {
                        duration = "0" + b + ":" + +c;
                    } else if (b > 10 && c < 10) {
                        duration = b + ":" + "0" + c;
                    }
                }
                return duration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
