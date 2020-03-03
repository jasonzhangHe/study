package com.guigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huguolu
 * @create 2020-02-19-13:18
 */
@SpringBootApplication
@EnableEurekaClient   //本服务启动后自动注入到Eureka中
@EnableDiscoveryClient  //服务发现类
public class DeptProvider8002_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002_APP.class,args);
    }

}
