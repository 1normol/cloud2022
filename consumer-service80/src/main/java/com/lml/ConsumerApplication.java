package com.lml;

import com.rule.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/30 10:07
 * @description：启动类
 * @modified By：
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "PAYMENT-SERVICE",configuration = RibbonRule.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
