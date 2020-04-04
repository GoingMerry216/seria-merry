package com.merry216.seria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口
 */
@SpringBootApplication(scanBasePackages = {"com.merry216"})
public class SeriaStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeriaStartApplication.class, args);
    }
}
