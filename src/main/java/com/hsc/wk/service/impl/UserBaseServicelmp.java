package com.hsc.wk.service.impl;

import com.hsc.wk.mapper.UserBaseMapper;
import com.hsc.wk.model.UserBase;
import com.hsc.wk.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBaseServicelmp implements UserBaseService {
    @Autowired
    private UserBaseMapper userBaseMapper;

    /**
     * 删除 * * @param id
     */
    @Override
    public void delete(int id) {
        userBaseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加 * * @param user
     */
    @Override
    public void insert(UserBase user) {
        userBaseMapper.insert(user);
    }

    /**
     * 更新 * * @param user
     */
    @Override
    public int update(UserBase user) {
        return userBaseMapper.updateByPrimaryKey(user);
    }

    /**
     * 查询单个 * * @param id
     */
    @Override
    public UserBase selectById(int id) {
        return userBaseMapper.selectByPrimaryKey(id);
    }
}
