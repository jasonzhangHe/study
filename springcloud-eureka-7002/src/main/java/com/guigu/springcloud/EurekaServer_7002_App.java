package com.guigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author huguolu
 * @create 2020-02-19-19:12
 */
@SpringBootApplication
@EnableEurekaServer       //告诉springboot这是一个eurekaserver注册服务 ，接受其它微服务注册进来
public class EurekaServer_7002_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002_App.class,args);
    }
}
