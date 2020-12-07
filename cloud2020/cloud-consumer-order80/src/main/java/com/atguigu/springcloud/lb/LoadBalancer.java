package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by 卢可欢 on 2020/11/29.
 */
public interface LoadBalancer {
    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
