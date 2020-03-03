package com.guigu.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author huguolu
 * @create 2020-02-20-21:43
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //return  new RandomRule();  //随机
          // return new RoundRobinRule();//轮巡
       return new myRandomRule();  //自定义算法
    }

}
