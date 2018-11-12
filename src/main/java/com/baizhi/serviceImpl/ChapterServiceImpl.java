package com.baizhi.serviceImpl;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Chapter> findAll() {

        List<Chapter> list = chapterDao.queryAll();
        return list;
    }

    @Override
    public void remove(String id) {
        chapterDao.delete(id);
    }

    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString());
        chapter.setC_date(new Date());
        chapter.setDownPath("/back/chapter/"+chapter.getDownPath());
        System.out.println(chapter);
        chapterDao.insert(chapter);
    }

    @Override
    public void update(Chapter chapter) {
        chapterDao.update(chapter);
    }
}
