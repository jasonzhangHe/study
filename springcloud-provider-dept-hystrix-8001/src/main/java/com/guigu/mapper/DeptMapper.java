package com.guigu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guigu.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huguolu
 * @create 2020-02-19-12:54
 */
@Mapper
public interface DeptMapper  extends BaseMapper<Dept> {
}
