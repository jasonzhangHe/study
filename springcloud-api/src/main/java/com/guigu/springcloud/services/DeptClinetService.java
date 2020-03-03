package com.guigu.springcloud.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * @author huguolu
 * @create 2020-02-21-10:53
 *
 * fegin和ribbon都能实现负载均衡
 */
//@FeignClient(value = "SPRINGCLOUD-DEPT")
@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)  //此处用到了fegin和hystrix中的服务降级，所以要在dept_fegin，yml中加
/*feign:
        hystrix:
        enabled: ture #feign开启hystrix，使其在api模块中的服务降级，统一处理熔断*/

public interface DeptClinetService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public  boolean add(@RequestBody Dept dept);

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept getByid(@PathVariable("id") Long id);
    @RequestMapping(value = "/dept/getall",method = RequestMethod.GET)
    public List<Dept> getall();
}
