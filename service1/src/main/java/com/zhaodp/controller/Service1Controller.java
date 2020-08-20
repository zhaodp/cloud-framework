package com.zhaodp.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaodp
 * @Date 2020-8-17
 */
@RestController
@Slf4j
@Api()
public class Service1Controller {
    @RequestMapping("/service1/test1")
    public String test1(@RequestParam(name = "id") String id) {
        return "test1 id:" + id;
    }
}
