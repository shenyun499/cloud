package com.xue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderDeptApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDeptApplication2.class, args);
    }
}
