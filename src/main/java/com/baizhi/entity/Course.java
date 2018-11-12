package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Course {
    private String id;
    private String title;
    private String marking;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date c_date;
    private String counter_id;
    private Counter counter;

    public Course() {
    }

    public Course(String id, String title, String marking, Date c_date, String counter_id, Counter counter) {

        this.id = id;
        this.title = title;
        this.marking = marking;
        this.c_date = c_date;
        this.counter_id = counter_id;
        this.counter = counter;
    }

    @Override

    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", marking='" + marking + '\'' +
                ", c_date=" + c_date +
                ", counter_id='" + counter_id + '\'' +
                ", counter=" + counter +
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

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public Date getC_date() {
        return c_date;
    }

    public void setC_date(Date c_date) {
        this.c_date = c_date;
    }

    public String getCounter_id() {
        return counter_id;
    }

    public void setCounter_id(String counter_id) {
        this.counter_id = counter_id;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
}
