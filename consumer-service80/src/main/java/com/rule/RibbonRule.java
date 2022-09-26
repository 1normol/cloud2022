package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：limaolin
 * @date ：Created in 2022/9/26 16:27
 * @description：Ribbon重写负载均衡策略，Ribbon官网明确指出不能放在被ComponentScan所扫描的，因此往上提一层
 * @modified By：
 */
@Configuration
public class RibbonRule {
    /**
     * 随机
     * @return
     */
    @Bean
    public IRule rule() {
        return new RandomRule();
    }

}
