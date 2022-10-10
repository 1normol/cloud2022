package com.lml.service;

import com.lml.entity.CommonResult;
import com.lml.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用openFeign进行远程调用
 */
@Component
@FeignClient("PAYMENT-SERVICE")
public interface PaymentFeign {
    /**
     * feign调用服务端
     * @param id
     * @return
     */
    @RequestMapping("/payment/queryById/{id}")
     CommonResult<Payment> queryById(@PathVariable("id") Long id);

    /**
     * 服务端睡眠3秒，调试feign客户端超时时间
     * @return
     */
    @RequestMapping("/payment/timeout")
    CommonResult timeout();
}
