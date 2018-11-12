package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {

    List<Album> findAll();

    List<Album> findTwo();

    Album findById(String id);

    void remove(String id);

    void add(Album album);

    void update(Album album);

}
