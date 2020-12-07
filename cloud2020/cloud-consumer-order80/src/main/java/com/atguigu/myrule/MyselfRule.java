package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 卢可欢 on 2020/11/29.
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
