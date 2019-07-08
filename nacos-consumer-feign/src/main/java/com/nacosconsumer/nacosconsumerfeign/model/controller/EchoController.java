package com.nacosconsumer.nacosconsumerfeign.model.controller;

import com.nacosconsumer.nacosconsumerfeign.model.interfaceService.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/echo/hi")
    public String echo(){
        return echoService.echo("Hi Feign");
    }
}
