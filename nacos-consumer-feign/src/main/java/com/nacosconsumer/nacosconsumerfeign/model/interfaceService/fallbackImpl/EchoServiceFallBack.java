package com.nacosconsumer.nacosconsumerfeign.model.interfaceService.fallbackImpl;

import com.nacosconsumer.nacosconsumerfeign.model.interfaceService.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallBack implements EchoService {
    @Override
    public String echo(String message) {
        return "服务崩溃，请检查！";
    }
}
