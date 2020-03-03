package com.guigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author huguolu
 * @create 2020-02-19-14:01
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})  //排除注入DataSourceAutoConfiguration类，加载自己配置的datasource
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.guigu.springcloud"})
/*@ComponentScan("com.guigu.springcloud")*/
public class DeptConsumer80_Fegin_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Fegin_App.class,args);
    }

}
