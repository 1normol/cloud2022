package com.lml.controller;

import com.lml.entity.CommonResult;
import com.lml.service.PaymentFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：limaolin
 * @date ：Created in 2022/9/29 11:28
 * @description：
 * @modified By：
 */

@RestController
@RequestMapping("/feign")
public class PaymentFeignController {
    @Resource
    private PaymentFeign paymentService;

    @GetMapping("/queryById/{id}")
    public CommonResult  order80(@PathVariable Long id){
        return paymentService.queryById(id);
    }

    @GetMapping("/timeout")
    public CommonResult timeout(){
        return paymentService.timeout();
    }
}
