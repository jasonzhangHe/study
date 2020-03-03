package com.guigu.springcloud;


import com.guigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author huguolu
 * @create 2020-02-19-14:01
 */

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})  //排除注入DataSourceAutoConfiguration类，加载自己配置的datasource
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }

}
