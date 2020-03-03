package com.guigu.controller;

import com.guigu.service.DeptService;
import com.guigu.springcloud.entity.Dept;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huguolu
 * @create 2020-02-19-13:09
 *
 * 服务熔断
 */
@RestController
public class DeptController {
  @Autowired
  private DeptService deptService;

//调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法

  @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
  @HystrixCommand(fallbackMethod = "processHystrix_Get")
  public Dept getByid(@PathVariable("id") Long id){
      Dept dept=this.deptService.getById(id);
      if(null == dept){
          throw  new RuntimeException("该id："+id+"没有对应的信息");
      }
      return dept;
  }


  public Dept processHystrix_Get(@PathVariable("id") Long id){
      return new Dept().setDeptNo(id).
              setDeptName("该id:"+id+"没有对应的信息,null--@HystrixCommand")
              .setDbSource("no this database in mysql");
  }
}

