package com.hsc.wk.service;

import com.hsc.wk.model.UserBase;

public interface UserBaseService {
    /**
     * 删除
     */
    public void delete(int id);

    /**
     * 增加
     */
    public void insert(UserBase user);

    /**
     * 更新
     */
    public int update(UserBase user);

    /**
     * 查询单个
     */
    public UserBase selectById(int id);

}
