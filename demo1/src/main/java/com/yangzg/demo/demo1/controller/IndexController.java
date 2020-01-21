package com.yangzg.demo.demo1.controller;

import com.yangzg.demo.demo1.model.Anchor;
import com.yangzg.demo.demo1.property.AnchorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * Created by Sam on 2020/1/20.
 * @author Sam
 */
@Controller
public class IndexController {
    @Autowired
    private AnchorProperties anchorProperties;

    @GetMapping({"", "/"})
    public String index(Map<String, Object> map) {
        System.out.println(this.anchorProperties);
        map.put("welcome", "主播列表");
        map.put("title", "biubiu...");
        map.put("users", Arrays.stream(this.anchorProperties.getUsers()).sorted(Comparator.comparingInt(Anchor::getAge).reversed()).toArray());
        return "index";
    }

    @GetMapping("/{id:\\d{3,9}}")
    public String anchor(@PathVariable int id, Map<String, Object> map) {
        final Map<Integer, Anchor> anchorMap = this.anchorProperties.getMap();
        if (anchorMap.containsKey(id)) {
            map.put("anchor", anchorMap.get(id));
            return "anchor";
        } else {
            return "anchor404";
        }
    }
}
