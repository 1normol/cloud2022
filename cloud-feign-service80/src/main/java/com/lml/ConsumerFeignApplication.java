package com.lml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：limaolin
 * @date ：Created in 2022/9/29 11:16
 * @description：
 * @modified By：
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class,args);
    }
}
