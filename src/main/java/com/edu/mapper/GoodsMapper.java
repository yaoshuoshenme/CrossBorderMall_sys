package com.edu.mapper;

import com.edu.commons.GoodsDynaSqlProvider;
import com.edu.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {
    int deleteByPrimaryKey(Integer gid);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    @Insert("insert into goods (gname, gtid, gpubdate,  gcreatedate, gprice, gstar, gpic, bid, ginfo ) values (#{gname}, #{gtid}, #{gpubdate}, now(),  #{gprice}, #{gstar}, #{gpic}, #{bid}, #{ginfo} )")
    int insert(Goods record);

    @SelectProvider(type = GoodsDynaSqlProvider.class,method = "selectWithParam")
    @ResultType(Goods.class)
    List<Goods> selectAll(Map param);
}