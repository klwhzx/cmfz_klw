package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {

    List<Chapter> findAll();

    void remove(String id);

    void add(Chapter chapter);

    void update(Chapter chapter);

}
