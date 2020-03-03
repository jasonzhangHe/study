package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.Dept;
import com.guigu.springcloud.services.DeptClinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author huguolu
 * @create 2020-02-19-13:39
 */
@RestController
public class DeptConsumerController  {

    @Autowired
    private DeptClinetService deptClinetService;


    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public  boolean addDept(@RequestBody Dept dept){
        return deptClinetService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id){
        return deptClinetService.getByid(id);
    }
    @RequestMapping(value = "/dept/getall",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return deptClinetService.getall();
    }
}
