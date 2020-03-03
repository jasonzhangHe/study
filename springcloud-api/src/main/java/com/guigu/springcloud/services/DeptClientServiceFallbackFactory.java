package com.guigu.springcloud.services;

import com.guigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author huguolu
 * @create 2020-02-22-21:51
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClinetService> {
    @Override
    public DeptClinetService create(Throwable throwable) {
        return new DeptClinetService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept getByid(Long id) {
                return new Dept().setDeptNo(id).
                        setDeptName("该id:"+id+"没有对应的信息,Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
                        .setDbSource("no this database in mysql");
            }

            @Override
            public List<Dept> getall() {
                return null;
            }
        };
    }
}
