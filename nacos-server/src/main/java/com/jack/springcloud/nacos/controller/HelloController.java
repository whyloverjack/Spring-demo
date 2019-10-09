package com.jack.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @GetMapping("/sayhello/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }


    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/test/nacos/config")
    public String getNacosConfig(){
        return "nacos config info:" + driverClassName + ";url:" + url + ";username:"+username + ";password:"+password;
    }

    @Value("${user.name}")
    private String name;

    @GetMapping("/test/nacos/member")
    public String getMemberConfig(){
        return "member:" + name;
    }
}
