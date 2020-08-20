package com.zhaodp.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhaodp
 * @Date 2020-8-17
 */
@Component
public class Service1FallBack implements Service1 {
    public String test1(@RequestParam(name = "id") String id) {
        return "call fail";
    }
}
