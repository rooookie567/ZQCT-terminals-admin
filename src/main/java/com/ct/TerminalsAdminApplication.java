package com.ct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ct.dao")
public class TerminalsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerminalsAdminApplication.class, args);
    }

}
