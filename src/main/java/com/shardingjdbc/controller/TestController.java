package com.shardingjdbc.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mirko on 2020/3/28.
 */
@RestController
public class TestController {



    @RequestMapping("/test")
    public Map<String,Object> getProperties(@RequestParam("version") String version){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("test", "test");
        if (!StringUtils.isEmpty(version) && version.equals("1")) {
            map.put("version", "1");
        }
        return map;
    }
}
