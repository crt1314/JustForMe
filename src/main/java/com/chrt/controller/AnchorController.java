package com.chrt.controller;

import com.chrt.pojo.Anchor;
import com.chrt.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 默认类中的方法都以json格式返回
@RestController
public class AnchorController {

    @Autowired
    private AnchorService anchorService;

    // 返回列表
    @RequestMapping("/main/{zone}")
    public List<Anchor> anchor(@PathVariable("zone") String zone) {
        return anchorService.findByZone(zone);
    }
}
