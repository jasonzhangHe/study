package com.guigu.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author huguolu
 * @create 2020-02-19-11:54
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("dept")
public class Dept  implements Serializable {  //类表关系映射,必须序列化接口
    @TableId(value = "dept_no",type = IdType.AUTO)
    private Long deptNo;
    private String deptName;
    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
