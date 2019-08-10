package com.hsc.wk.mapper;

import com.hsc.wk.model.UserBase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserAnnotationMapper {
    @Select("select * from userbase")
    List<UserBase> selectUserAll();

    @Select("select * from userbase where id=#{id}")
    UserBase selectByPrimaryKeyId(@Param("id") int id);
}
