package com.zhaodp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhaodp
 * @Date 2020-8-17
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zhaodp.dao")
public class Service8001 {
    public static void main(String[] args) {
        SpringApplication.run(Service8001.class, args);
    }
}
