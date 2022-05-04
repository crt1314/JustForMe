package com.chrt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chrt
 *
 * @version 1.0.0
 *
 * */

@SpringBootApplication
@MapperScan("com.chrt.mapper")
@RestController
public class JustForMeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JustForMeApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }
}
