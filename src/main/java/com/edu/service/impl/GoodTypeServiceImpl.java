package com.edu.service.impl;

import com.edu.mapper.GoodTypeMapper;
import com.edu.pojo.GoodType;
import com.edu.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodTypeServiceImpl implements GoodTypeService {

    @Autowired
    private GoodTypeMapper gm;

    @Override
    @Transactional(readOnly = true)
    public List<GoodType> selectAll(Integer level) {
        return gm.selectAll(level);
    }

    @Override
    public boolean insertType(GoodType type) {

        //判断加入的是否为一级类目
        type.setGtlevel(null != type.getGtparentid() ? 2 : 1);
        return gm.insert(type) > 0 ? true : false;
    }

    @Override
    public boolean checkType(String gtname) {

        return gm.findByName(gtname) != null ? true:false;
    }

    @Override
    public List<GoodType> selectActive(String gtlevel, String gtname) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gtlevel",gtlevel);
        map.put("gtname",gtname);
        return gm.selectActive(map);
    }

    @Override
    public GoodType selectbykey(String gtid) {

        return gm.selectByPrimaryKey(gtid);
    }

    @Override
    public boolean updateType(GoodType goodType) {
        return gm.updateByRecord(goodType) > 0 ? true : false;
    }

}
