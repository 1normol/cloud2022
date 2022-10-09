package com.lml.controller;


import com.lml.service.PaymentHysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/29 15:31
 * @description：控制层
 * @modified By：
 */
@RestController
@Slf4j
@EnableEurekaClient
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentHysService paymentService;
    @GetMapping("/info/{id}")
    public String  info(@PathVariable Integer id){
        String result = paymentService.paymentInfo(id);
        log.info("result:{}",result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String timeout(@PathVariable Integer id){
        String result = paymentService.paymentTimeout(id);
        log.info("result:{}",result);
        return result;
    }

}
