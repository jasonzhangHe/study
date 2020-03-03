package com.guigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author huguolu
 * @create 2020-02-23-21:46
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableConfigServer   //开启Config服务端
public class Config_StartSpringCloud_3344_App {
    public static void main(String[] args) {
        SpringApplication.run(Config_StartSpringCloud_3344_App.class,args);
    }
}
