package com.lml.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：limaolin
 * @date ：Created in 2022/10/10 9:42
 * @description：
 * @modified By：
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator  customRoute(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("",paymentRout->
                paymentRout.path("/test")
                        .uri("https://www.baidu.com")).build();
        return routes.build();
    }
}
