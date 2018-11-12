package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Album {
    private String id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date p_date;
    private Integer count;
    private String coverImg;
    private String star;
    private String author;
    private String broadCast;
    private String brief;
    private List<Chapter> children = new ArrayList<Chapter>();
    public Album() {
    }

    public Album(String id, String title, Date p_date, Integer count, String coverImg, String star, String author, String broadCast, String brief, List<Chapter> children) {

        this.id = id;
        this.title = title;
        this.p_date = p_date;
        this.count = count;
        this.coverImg = coverImg;
        this.star = star;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.children = children;
    }



    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", p_date=" + p_date +
                ", count=" + count +
                ", coverImg='" + coverImg + '\'' +
                ", star='" + star + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", children=" + children +
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

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }
}
