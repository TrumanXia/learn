package com.xyg.learn.redisson.controller;

import com.xyg.learn.redisson.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 97994
 * @since 2020-09-25
 */
@RestController
@Scope("request")
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hello")
    public int hello() {
//        AntPathMatcher
        return helloService.hello();
    }
}
