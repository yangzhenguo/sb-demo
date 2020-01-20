package com.yangzg.demo.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by Sam on 2020/1/20.
 * @author Sam
 */
@Controller
public class IndexController {
    @GetMapping({"", "/"})
    public String index(Map<String, Object> map) {
        map.put("hello", "Hello Spring Boot");
        return "index";
    }
}
