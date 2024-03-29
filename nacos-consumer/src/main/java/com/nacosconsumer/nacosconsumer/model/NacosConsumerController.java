package com.nacosconsumer.nacosconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value = "/echo/app/name")
    public String echo(){
        // 使用 LoadBalancerClient 和 RestTemplate 结合方式访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String strUrl = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(),serviceInstance.getPort(),appName);
        return restTemplate.getForObject(strUrl,String.class);
    }
}
