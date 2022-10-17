package com.lml.config;

import com.lml.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/17 15:56
 * @description：配置类
 * @modified By：
 */
@Component
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 使拦截器生效
        registry.addInterceptor(new LoginInterceptor());
    }
}
