package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Banner {
    private String id;
    private String title;
    private String imgPath;
    private String dasc;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date b_date;

    public Banner() {
    }

    public Banner(String id, String title, String imgPath, String dasc, String status, Date b_date) {

        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.dasc = dasc;
        this.status = status;
        this.b_date = b_date;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", dasc='" + dasc + '\'' +
                ", status='" + status + '\'' +
                ", b_date=" + b_date +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDasc() {
        return dasc;
    }

    public void setDasc(String dasc) {
        this.dasc = dasc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getB_date() {
        return b_date;
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }
}
