package com.nacosconsumer.nacosconsumerfeign.model.interfaceService;

import com.nacosconsumer.nacosconsumerfeign.model.interfaceService.fallbackImpl.EchoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = EchoServiceFallBack.class)
public interface EchoService {
    @GetMapping(value = "/echo/{message}")
    String echo(@PathVariable("message") String message);
}
