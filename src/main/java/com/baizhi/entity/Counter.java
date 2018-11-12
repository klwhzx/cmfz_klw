package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Counter {
    private String id;
    private String title;
    private Integer count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date r_date;
    private String user_id;

    public Counter() {
    }

    public Counter(String id, String title, Integer count, Date r_date, String user_id) {

        this.id = id;
        this.title = title;
        this.count = count;
        this.r_date = r_date;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                ", r_date=" + r_date +
                ", user_id='" + user_id + '\'' +
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
