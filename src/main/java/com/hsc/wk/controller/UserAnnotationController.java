package com.hsc.wk.controller;

import com.github.pagehelper.PageInfo;
import com.hsc.wk.model.PageResult;
import com.hsc.wk.model.UserBase;
import com.hsc.wk.service.UserAnnotationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alluserbase")
public class UserAnnotationController {
    @Autowired
    private UserAnnotationservice userAnnotationservice;
    @RequestMapping(method = RequestMethod.GET, value = "/selectAll")
    public List<UserBase> selectAll() {
        return userAnnotationservice.selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectAllUser/{pageNum}/{pageSize}")
    public PageResult<List<UserBase>> selectAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        return userAnnotationservice.selectAll(pageNum, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectPageUser/{pageNum}/{pageSize}")
    public PageInfo<UserBase> selectPageAll(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        return userAnnotationservice.selectPageAll(pageNum, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/selectById/{id}")
    public UserBase selectById(@PathVariable("id") int id) {

        return userAnnotationservice.selectById(id);
    }
}
