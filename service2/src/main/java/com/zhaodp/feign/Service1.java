package com.zhaodp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author zhaodp
 * @Date 2020-8-17
 */
@FeignClient(name = "service8001",fallback = Service1FallBack.class)
public interface Service1 {
    @RequestMapping("/service1/test1")
    String test1(@RequestParam(name = "id") String id);
}
