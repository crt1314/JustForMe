package com.chrt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author chrt
 *
 * @version 1.0.0
 *
 * */

@SpringBootApplication
@MapperScan("com.chrt.mapper")
public class JustForMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JustForMeApplication.class, args);
    }
}
