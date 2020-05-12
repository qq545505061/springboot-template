package com.li;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@MapperScan("com.zs.dao")
public class ZsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsApplication.class, args);
    }

}
