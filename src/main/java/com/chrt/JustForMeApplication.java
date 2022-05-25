package com.chrt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author chrt
 * @version 1.0.1
 * */

@SpringBootApplication
@MapperScan("com.chrt.mapper")
public class JustForMeApplication {
    /**
     * 该项目入口
     * @param args 参数
     */
    public static void main(String[] args) {
        SpringApplication.run(JustForMeApplication.class, args);
    }
}
