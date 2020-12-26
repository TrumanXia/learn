package com.xyg.learn.redisson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 97994
 * @since 2020-09-25
 */
@Component
public class HelloService {
    @Autowired
    HelloService helloService;

    public int hello() {
        return helloService.doHello();
    }

    private int doHello() {
        return 1;
    }

}
