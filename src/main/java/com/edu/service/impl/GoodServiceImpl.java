package com.edu.service.impl;

import com.edu.mapper.GoodsMapper;
import com.edu.pojo.Goods;
import com.edu.service.GoodService;
import com.edu.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsMapper gm;

    @Override
    public boolean addGoods(Goods goods) {

        return gm.insert(goods) > 0 ? true : false;
    }

    @Override
    public List<Goods> getGoodList(String gname, String gpubdate) throws ParseException {
        Date date = null;
        if(null != gpubdate){
            date = DateUtil.ToDate(gpubdate);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gname",gname);
        map.put("gpubdate", date);
        return gm.selectAll(map);
    }
}
