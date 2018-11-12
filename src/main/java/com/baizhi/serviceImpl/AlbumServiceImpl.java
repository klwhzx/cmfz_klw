package com.baizhi.serviceImpl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll() {
        List<Album> list = albumDao.queryAll();
        return list;
    }

    @Override
    public void remove(String id) {
        albumDao.delete(id);
    }

    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString());
        album.setP_date(new Date());
        album.setCoverImg("/back/xgtp/albumImg/" + album.getCoverImg());
        albumDao.insert(album);
    }

    @Override
    public void update(Album album) {
        album.setP_date(new Date());
        album.setCoverImg("/back/xgtp/albumImg/" + album.getCoverImg());
        albumDao.update(album);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findTwo() {
        List<Album> list = albumDao.querys();
        return list;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findById(String id){
        Album albums = albumDao.queryById(id);
        return albums;
    }
}
