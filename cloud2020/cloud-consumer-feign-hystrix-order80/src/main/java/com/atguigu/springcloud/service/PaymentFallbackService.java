package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by 卢可欢 on 2020/12/2.
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "111";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "111";
    }
}
