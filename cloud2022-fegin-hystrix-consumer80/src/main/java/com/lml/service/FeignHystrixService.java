package com.lml.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 35541
 */
@Component
@FeignClient("PAYMENT-HYSTRIX-SERVICE")
public interface FeignHystrixService {
    /**
     * feign调用
     * @param id
     * @return
     */
    @GetMapping("/payment/info/{id}")
    String info(@PathVariable(value = "id") Integer id);

    /**
     * feign调用，调试断路器
     * @param id
     * @return
     */
    @GetMapping("/payment/timeout/{id}")
    String timeout(@PathVariable(value = "id") Integer id);
}
