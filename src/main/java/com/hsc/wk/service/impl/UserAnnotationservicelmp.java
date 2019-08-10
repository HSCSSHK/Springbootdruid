package com.hsc.wk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hsc.wk.mapper.UserAnnotationMapper;
import com.hsc.wk.model.PageResult;
import com.hsc.wk.model.UserBase;
import com.hsc.wk.service.UserAnnotationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAnnotationservicelmp implements UserAnnotationservice {
    @Autowired
    private UserAnnotationMapper userAnnotationMapper;
    /**
     * 查询全部列表,并做分页 * * @param pageNum 开始页数 * @param pageSize 每页显示的数据条数
     */
    @Override
    public List<UserBase> selectAll() { 

        return userAnnotationMapper.selectUserAll();
    }
    @Override
    public PageResult<List<UserBase>> selectAll(Integer  pageNum, Integer  pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。

        PageHelper.startPage(pageNum,pageSize);
        final List<UserBase> users =  userAnnotationMapper.selectUserAll();
        final PageInfo pageInfo = new PageInfo(users);

        //PageHelper.clearPage();

        final PageResult<List<UserBase>> pageResult = PageResult.sucessOf(users);
        pageResult.setPageNumber(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setPageTotal(pageInfo.getTotal());
        return pageResult;
    }

    @Override
    public PageInfo<UserBase> selectPageAll(Integer  pageNum, Integer  pageSize) {
        System.out.println("selectPageAll ---  pageNum="+pageNum+";pageSize="+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<UserBase> UserList = userAnnotationMapper.selectUserAll();
        PageInfo<UserBase> pageInfo = new PageInfo<UserBase>(UserList);
        return pageInfo;

    }

    @Override
    public UserBase selectById(int  id) {

        UserBase UserList = userAnnotationMapper.selectByPrimaryKeyId(id);

        return UserList;

    }
}
