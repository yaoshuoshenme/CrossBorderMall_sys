package com.edu.mapper;

import com.edu.pojo.Backuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BackuserMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Backuser record);

    int insertSelective(Backuser record);

    Backuser selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Backuser record);

    int updateByPrimaryKey(Backuser record);

    Backuser selectByName(@Param("bname") String bname, @Param("bpassword") String bpassword);
}