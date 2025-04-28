package com.jjou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2025-03-18 15:27
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jjou.mapper")
public class MyMavenApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyMavenApplication.class, args);
    }
}
