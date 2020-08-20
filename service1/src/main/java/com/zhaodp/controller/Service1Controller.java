package com.zhaodp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhaodp
 * @Date 2020-8-17
 */
@RestController
@Slf4j
@Api(tags = "服务1")
public class Service1Controller {
    @ApiOperation(value = "service1接口")
    @GetMapping("/service1/test1")
    public String test1(@ApiParam(name = "id",value = "租户id") @RequestParam(name = "id") String id) {
        return "test1 id:" + id;
    }
}
