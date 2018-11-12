package com.baizhi.serviceImpl;

import com.baizhi.dao.GurnDao;
import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GurnServiceImpl implements GurnService {

    @Autowired
    private GurnDao gurnDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gurn> quaryGurn() {
        List<Gurn> list = gurnDao.queryAll();
        return list;
    }

    @Override
    public void removeGurn(String id) {
        gurnDao.delete(id);
    }

    @Override
    public void addGurn(Gurn gurn) {
        gurn.setId(UUID.randomUUID().toString());
        gurn.setHeadPic("/back/xgtp/albumImg/"+gurn.getHeadPic());
        gurn.setStatus("正常");
        gurnDao.insert(gurn);
    }

    @Override
    public void updateGurn(Gurn gurn) {

        gurnDao.update(gurn);
    }
}
