package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author huguolu
 * @create 2020-02-19-13:39
 */
@RestController
public class DeptController_consumer {


    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-DEPT";
    
    /**
     * 通过resttemplate发送restful请求
     *
     * (url,response,responsebean.class)
     * rest请求地址，请求参数，
     * Http响应装换被装换成的对象类型
     */


    @Autowired
    private  RestTemplate  restTemplate;


    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",dept,Boolean.class);
    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept findbyid(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @SuppressWarnings("unchecked")  //关闭检查
    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
    //测试@EnableDiscoveryClient
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }

}
