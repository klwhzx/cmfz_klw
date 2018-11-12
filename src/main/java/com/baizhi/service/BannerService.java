package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {

    List<Banner> quaryBanner();

    void removeImg(String id);

    void addImg(Banner banner);

    void updateImg(Banner banner);

}
