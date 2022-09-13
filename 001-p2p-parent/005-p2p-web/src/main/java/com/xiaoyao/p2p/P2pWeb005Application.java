package com.xiaoyao.p2p;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class P2pWeb005Application {

    public static void main(String[] args) {
        SpringApplication.run(P2pWeb005Application.class, args);
    }

}
