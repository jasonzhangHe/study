package com.guigu.springcloud.config;

import com.guigu.myrule.myRandomRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author huguolu
 * @create 2020-02-19-13:34
 */
@Configuration    //配置类
public class ConfigBeans {


    /**
     *配置RestTemplate
     *      * 通过RestTemplate调用提供者服务 ，发送rest请求
     *      * 提供了多种访问http服务的方法，
     *      * 针对于访问rest服务<strong>客户端</strong>的调用的模板类
     *
     */
    @Bean
    @LoadBalanced    //开启负载均衡
    public RestTemplate getRestTemplate(){
        return   new RestTemplate();
    }

    @Bean
    public IRule  myRule(){
       return  new RandomRule();  //达到的目的，用我们重新选择的随机算法代替默认的轮询
       // return new  RetryRule();
       // return new myRandomRule();
    }

}
