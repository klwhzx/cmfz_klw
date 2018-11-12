package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumDao extends BaseDao<Album> {

    List<Album> querys();

}
