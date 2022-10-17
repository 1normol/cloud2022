package com.lml.controller;


import com.lml.entity.CommonResult;
import com.lml.entity.Payment;
import com.lml.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService paymentService;
    @RequestMapping("/add")
    public CommonResult addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if (result > 0){
            log.info("成功添加");
            return new CommonResult(200,"成功返回");
        }else{
            return new CommonResult(444,"失败");
        }
    }

    @RequestMapping("/queryById/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment =  paymentService.queryPayment(id);
        if (payment != null){
            log.info("查询成功，当前端口号是{}",serverPort);
            return new CommonResult(200,"成功返回,当前端口号是:"+serverPort,payment);
        }else{
            log.error("查询失败");
            return new CommonResult(444,"失败");
        }
    }

    /**
     * 服务发现discovery的简单使用
     * @return
     */
    @GetMapping("/discovery")
    public CommonResult getServices(){
        List<String> services = discoveryClient.getServices();
        //发现所有微服务
        services.forEach(service->{
            log.info(service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        //根据微服务ID拿到该服务下的所有实例
        instances.forEach(instance->{
            log.info("该实例的端口号是:{},主机是:{},服务Id是:{}.实例路径是:{}",instance.getPort(),instance.getHost(),instance.getServiceId(),instance.getUri());
        });
        return new CommonResult(200,"成功",discoveryClient);
    }
}
