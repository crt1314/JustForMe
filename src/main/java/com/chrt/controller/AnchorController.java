package com.chrt.controller;

import com.chrt.pojo.Anchor;
import com.chrt.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Anchor相关控制流程
 * @author chrt
 * @version 1.0.0
 */
@RestController
public class AnchorController {

    @Autowired
    private AnchorService anchorService;

    /**
     * 返回一个列表
     * @param zone ajax传递过来的查询条件
     * @return Anchor列表
     */
    @RequestMapping("/anchor/{zone}")
    public List<Anchor> anchor(@PathVariable("zone") String zone) {
        return anchorService.findByZone(zone);
    }
}
