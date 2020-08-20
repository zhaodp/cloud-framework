package com.zhaodp.controller;

import com.zhaodp.feign.Service1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zhaodp
 * @Date 2020-8-17
 */
@RestController
@Slf4j
public class Service2Controller {

    @Resource
    Service1 service1;

    @RequestMapping("/service2/test1")
    public String test1(@RequestParam(name = "id") String id) {
        return service1.test1(id);
    }
}
