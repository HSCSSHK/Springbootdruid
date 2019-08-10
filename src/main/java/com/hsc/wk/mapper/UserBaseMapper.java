package com.hsc.wk.mapper;

import com.hsc.wk.model.UserBase;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}