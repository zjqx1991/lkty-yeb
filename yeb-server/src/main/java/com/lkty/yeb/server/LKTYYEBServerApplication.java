package com.lkty.yeb.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

//@EnableFeignClients
//@EnableTransactionManagement //开启事务
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = {"com.lkty.yeb.server", "com.lkty.yeb.common.handler", "com.lkty.yeb.common.config"})
public class LKTYYEBServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LKTYYEBServerApplication.class, args);
    }
}
