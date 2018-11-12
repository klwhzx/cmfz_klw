package com.baizhi.serviceImpl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> quaryBanner() {
        List<Banner> list = bannerDao.queryAll();

        return list;
    }

    @Override
    public void removeImg(String id) {
        bannerDao.delete(id);
    }

    @Override
    public void addImg(Banner banner){
        banner.setId(UUID.randomUUID().toString());
        banner.setB_date(new Date());
        banner.setImgPath("/back/xgtp/bannerImg/"+banner.getImgPath());
        System.out.println(banner);
        bannerDao.insert(banner);
    }

    @Override
    public void updateImg(Banner banner){
        banner.setB_date(new Date());
        System.out.println(banner);
        bannerDao.update(banner);
    }



}
