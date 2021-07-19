package com.xue.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注入过滤器
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2021-07-19
 */
@Configuration
public class InjectWebFilter {
    private final static Logger log = LoggerFactory.getLogger(InjectWebFilter.class);

    @Bean
    public WebFilter webFilter() {
        log.info(" inject webFilter success!");
        WebFilter webFilter = new WebFilter();
        return webFilter;
    }
}
