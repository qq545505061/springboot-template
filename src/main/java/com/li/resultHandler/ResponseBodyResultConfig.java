package com.li.resultHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册responseBody处理器
 * 统一封装responseBody（方式一）
 */
@Configuration
public class ResponseBodyResultConfig {

//    @Bean
    public ResponseBodyWrapFactoryBean getResponseBodyWrap() {
        System.out.println("----------初始化responseBody处理器bean----------");
        return new ResponseBodyWrapFactoryBean();
    }
}
