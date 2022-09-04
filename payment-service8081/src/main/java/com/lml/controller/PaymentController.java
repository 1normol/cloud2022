package com.lml.controller;

import com.lml.CommonResult;
import com.lml.entity.Payment;
import com.lml.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/29 15:31
 * @description：控制层
 * @modified By：
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @RequestMapping("/add")
    public CommonResult addPayment(Payment payment){
        int result = paymentService.addPayment(payment);
        if (result > 0){
            log.info("成功添加");
            return new CommonResult(200,"成功返回");
        }else{
            return new CommonResult(444,"失败");
        }
    }

    @RequestMapping("queryById")
    public CommonResult queryById(@RequestParam("id") Long id){
        Payment payment = paymentService.queryPayment(id);
        if (payment != null){
            log.info("查询成功");
            return new CommonResult(200,"成功返回",payment);
        }else{
            return new CommonResult(444,"失败");
        }
    }
}
