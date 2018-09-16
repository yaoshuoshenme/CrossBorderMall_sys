package com.edu.service;

import com.edu.pojo.Goods;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface GoodService {
    boolean addGoods( Goods goods) ;

    List<Goods> getGoodList(String gname, String gcreatedate) throws ParseException;

}
