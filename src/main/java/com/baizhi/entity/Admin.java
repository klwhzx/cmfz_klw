package com.baizhi.entity;

public class Admin {

    private String id;
    private String name;
    private String tel;
    private String password;


    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
