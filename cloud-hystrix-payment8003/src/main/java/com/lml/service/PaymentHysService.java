package com.lml.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/9 10:55
 * @description：
 * @modified By：
 */
@Service
@DefaultProperties(defaultFallback = "globalHystrix")
public class PaymentHysService {

    @HystrixCommand
    public String paymentInfo(Integer id){
        int i = 10/0;
        return "线程池:"+Thread.currentThread().getName()+"Payment--Info_Ok ^^^^^^";
    }


    @HystrixCommand(fallbackMethod = "fallbackTimeOut",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentTimeout(Integer id){
        int i = 10/0;
        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {throw new RuntimeException(e);}
        return "线程池:"+Thread.currentThread().getName()+"Payment--Time_Out -------";
    }

    public String fallbackTimeOut(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"进入了服务降级方法O(∩_∩)O";
    }

    public String globalHystrix(){
        return "global全局降级(￣▽￣)";
    }
}
