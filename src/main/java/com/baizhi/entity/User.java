package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private String id;
    private String f_name;
    private String name;
    private String tel;
    private String password;
    private String sex;
    private String address;
    private String mark;
    private String img;
    private String stauts;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date s_date;
    private String ip;
    private Course course;

    public User() {
    }

    public User(String id, String f_name, String name, String tel, String password, String sex, String address, String mark, String img, String stauts, Date s_date, String ip, Course course) {

        this.id = id;
        this.f_name = f_name;
        this.name = name;
        this.tel = tel;
        this.password = password;
        this.sex = sex;
        this.address = address;
        this.mark = mark;
        this.img = img;
        this.stauts = stauts;
        this.s_date = s_date;
        this.ip = ip;
        this.course = course;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", f_name='" + f_name + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", mark='" + mark + '\'' +
                ", img='" + img + '\'' +
                ", stauts='" + stauts + '\'' +
                ", s_date=" + s_date +
                ", ip='" + ip + '\'' +
                ", course=" + course +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public Date getS_date() {
        return s_date;
    }

    public void setS_date(Date s_date) {
        this.s_date = s_date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
