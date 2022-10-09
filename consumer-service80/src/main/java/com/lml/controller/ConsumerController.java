package com.lml.controller;
import com.lml.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@Slf4j
@EnableEurekaClient
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    String url = "http://PAYMENT-SERVICE";
    @RequestMapping("/payment/creat1")
    public CommonResult consumer(Payment payment){
        return restTemplate.postForObject(url+"/payment/add",payment,CommonResult.class);
    }
    @RequestMapping("/payment/query/{id}")
    public CommonResult query(@PathVariable Long id){
       return restTemplate.getForObject(url+"/payment/queryById/"+id,CommonResult.class);
    }

    @RequestMapping("/payment/getForEntity/{id}")
    public CommonResult query1(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(url + "/payment/queryById/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info("成功发送请求，请求头为{},响应码为{},响应体为{}",entity.getHeaders(),entity.getStatusCode(),entity.getBody());
            return entity.getBody();
        }else {
            log.error("443","请求失败");
            return new CommonResult<>(443,"请求失败");
        }
    }

    @RequestMapping("/payment/postForObject/{id}")
    public CommonResult query2(@PathVariable Long id) {
        return restTemplate.postForObject(url + "/payment/queryById/"+id , id, CommonResult.class);
    }

    @RequestMapping("/payment/postForEntity/{id}")
    public CommonResult query23(@PathVariable Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(url + "/payment/queryById/" + id, id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info("成功发送请求，请求头为{},响应码为{},响应体为{}",entity.getHeaders(),entity.getStatusCode(),entity.getBody());
            return entity.getBody();
        }else {
            log.error("443","请求失败");
            return new CommonResult<>(443,"请求失败");
        }
    }


}