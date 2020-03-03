package com.guigu.controller;

import com.guigu.service.DeptService;
import com.guigu.springcloud.entity.Dept;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huguolu
 * @create 2020-02-19-13:09
 */
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public  boolean add(@RequestBody Dept dept){
        return deptService.save(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept getByid(@PathVariable("id") Long id){
         return deptService.getById(id);
    }
    @RequestMapping(value = "/dept/getall",method = RequestMethod.GET)
    public List<Dept> getall(){
        return deptService.list(null);
    }
     //服务发现ip，端口
    @RequestMapping(value="/dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("**********"+services);
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-DEPT");
        for (ServiceInstance element:instances) {
            System.out.println(element);
        }
        return  this.discoveryClient;
    }
}
