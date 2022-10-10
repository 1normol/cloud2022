package com.lml.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：limaolin
 * @date ：Created in 2022/9/29 13:51
 * @description：Feign配置类
 * @modified By：
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
