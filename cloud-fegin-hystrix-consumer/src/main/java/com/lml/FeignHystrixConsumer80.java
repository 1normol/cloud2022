package com.lml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/9 11:29
 * @description：启动类
 * @modified By：
 */

@EnableFeignClients
@SpringBootApplication
public class FeignHystrixConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixConsumer80.class, args);
    }
}
