package com.hsc.wk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public Map<String,String> index(){
        Map map = new HashMap<String,String>();
        map.put("北京","北方城市");
        map.put("广州","南方城市");
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city")
    public Map<String,String> getCity(HttpServletRequest request){
        Map map = new HashMap<String,String>();
        map.put("北京","北方城市");
        map.put("广州","南方城市");
        map.put("深圳","南方城市");
        log.info("map = {}",map);
        return map;
    }
}
