package com.hsc.wk.controller;

import com.hsc.wk.model.UserBase;
import com.hsc.wk.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userbase")
public class UserBaseController {
    @Autowired
    private UserBaseService userBaseService;

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userBaseService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public void insert(UserBase user) {
        userBaseService.insert(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{id}")
    public void update(@RequestParam UserBase user) {
        userBaseService.update(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/select")
    public UserBase select(@PathVariable("id") int id) {
        return userBaseService.selectById(id);
    }
}
