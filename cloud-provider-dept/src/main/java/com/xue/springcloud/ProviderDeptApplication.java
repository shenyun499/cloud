package com.xue.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
public class ProviderDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDeptApplication.class, args);
    }
}
