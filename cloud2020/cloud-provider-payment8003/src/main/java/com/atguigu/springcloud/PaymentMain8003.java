package com.atguigu.springcloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by 卢可欢 on 2020/11/10.
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class,args);
    }
}
