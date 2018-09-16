package com.edu.service;

import com.edu.pojo.GoodType;

import java.util.List;


public interface GoodTypeService {


    List<GoodType> selectAll(Integer level);

    boolean insertType(GoodType type);

    boolean checkType(String gtname);

    List<GoodType> selectActive(String gtlevel, String gtname);

    GoodType selectbykey(String gtid);

    boolean updateType(GoodType goodType);
}
