package com.hsc.wk.service;

import com.github.pagehelper.PageInfo;
import com.hsc.wk.model.PageResult;
import com.hsc.wk.model.UserBase;

import java.util.List;

public interface UserAnnotationservice {

    /**
     * 查询全部列表
     */
    public List<UserBase> selectAll();

    public PageResult<List<UserBase>> selectAll(Integer pageNum, Integer pageSize);

    public PageInfo<UserBase> selectPageAll(Integer pageNum, Integer pageSize);

    public UserBase selectById(int id);
}
