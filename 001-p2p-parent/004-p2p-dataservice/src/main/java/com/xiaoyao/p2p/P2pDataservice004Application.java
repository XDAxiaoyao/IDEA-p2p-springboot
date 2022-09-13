package com.xiaoyao.p2p;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaoyao.p2p.mapper")
@EnableDubboConfiguration
public class P2pDataservice004Application {

    public static void main(String[] args) {
        SpringApplication.run(P2pDataservice004Application.class, args);
    }

}
