package com.lml.controller;
import com.lml.entity.CommonResult;
import com.lml.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/30 10:21
 * @description：消费者控制层
 * @modified By：
 */

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    String url = "http://localhost:8081";
    @RequestMapping("/payment/creat")
    public CommonResult consumer(Payment payment){
        return restTemplate.postForObject(url+"/payment/add",payment,CommonResult.class);
    }
    @RequestMapping("/payment/query/{id}")
    public CommonResult query(@PathVariable Long id){
       return restTemplate.getForObject(url+"/payment/queryById/"+id,CommonResult.class);
    }
}
