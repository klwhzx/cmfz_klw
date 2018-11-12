package com.baizhi.service;

import com.baizhi.entity.Gurn;

import java.util.List;

public interface GurnService {

    List<Gurn> quaryGurn();

    void removeGurn(String id);

    void addGurn(Gurn gurn);

    void updateGurn(Gurn Gurn);

}
