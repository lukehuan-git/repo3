package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by 卢可欢 on 2020/11/30.
 */
@Service
public class PaymentService {
    public String paymentInfoOk(Integer id){
        return "线程池:  "+Thread.currentThread().getName()+"id:"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfoTimeOut(Integer id){
        int time=3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  "+Thread.currentThread().getName()+"TimeOut,id:"+id+"耗时"+time;
    }
    public String paymentInfoTimeOutHandler(Integer id){

            return "线程池:  "+Thread.currentThread().getName()+"paymentInfoTimeOutHandler,id:"+id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0)throw new RuntimeException("id不能为负数");
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+ UUID.randomUUID().toString();
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "id不能为负数";
    }
}
