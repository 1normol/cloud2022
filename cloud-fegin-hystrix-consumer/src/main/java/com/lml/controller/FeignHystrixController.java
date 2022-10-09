package com.lml.controller;

import com.lml.service.FeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/9 11:30
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/feign/hystrix")
public class FeignHystrixController {
    @Resource
    public FeignHystrixService feignHystrixService;
    @RequestMapping("/info/{id}")
    public String info(@PathVariable(value = "id") Integer id){
        return feignHystrixService.info(id);
    }
    @RequestMapping("/timeout/{id}")
    public String timeout(@PathVariable(value = "id") Integer id){
        return feignHystrixService.timeout(id);
    }
}
