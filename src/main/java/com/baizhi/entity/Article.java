package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private String id;
    private String title;
    private String imgPath;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date p_date;
    private String imgTuh;
    private String grun_id;

    public Article(String id, String title, String imgPath, String content, Date p_date, String imgTuh, String grun_id) {
        this.id = id;
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.p_date = p_date;
        this.imgTuh = imgTuh;
        this.grun_id = grun_id;
    }

    public Article() {

    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", content='" + content + '\'' +
                ", p_date=" + p_date +
                ", imgTuh='" + imgTuh + '\'' +
                ", grun_id='" + grun_id + '\'' +
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public String getImgTuh() {
        return imgTuh;
    }

    public void setImgTuh(String imgTuh) {
        this.imgTuh = imgTuh;
    }

    public String getGrun_id() {
        return grun_id;
    }

    public void setGrun_id(String grun_id) {
        this.grun_id = grun_id;
    }
}
