package com.edu.mapper;

import com.edu.commons.GoodTypeDynaSqlProvider;
import com.edu.pojo.GoodType;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodTypeMapper {

    @Update("update goodtype set gtname=#{gtname},gtlevel=#{gtlevel},gtparentid=#{gtparentid} where gtid = #{gtid}")
    int updateByRecord(GoodType record);

    @Select("select *from goodtype where gtid=#{gtid}")
    @ResultType(GoodType.class)
    GoodType selectByPrimaryKey(String gtid);

    @Insert("insert into goodtype (gtname, gtlevel, gtparentid) values (#{gtname}, #{gtlevel}, #{gtparentid})")
    @Options(useGeneratedKeys = true)
    int insert(GoodType record);

    @Select("select *from goodtype gt where gtlevel= #{gtlevel}")
    @ResultType(GoodType.class)
    List<GoodType> selectAll(Integer level);

    @Select("select gtid from goodtype where gtname = #{gtname}")
    GoodType findByName(String gtname);

    @SelectProvider(type = GoodTypeDynaSqlProvider.class,method = "selectWithParam")
    List<GoodType> selectActive(Map<String, Object> map);
}