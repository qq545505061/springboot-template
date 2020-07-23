package com.li.config;

import com.li.conditional.WindowsConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileTestConfig {

    @Profile("dev")
    @Conditional(WindowsConditional.class)
    @Bean
    public void test() {
        System.out.println("test...........");
    }
}
