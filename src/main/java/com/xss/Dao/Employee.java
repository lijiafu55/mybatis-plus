package com.xss.Dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/*
  @ 2023， 04， 26， 15，23
  @ 15303  MP
  @ 15303  com.xss.Dao 15:23
*/
@Data
//实体类与数据库映射
@TableName("tb_employee")
public class Employee {

        private Long id;
        private String lastName;
        private String email;
        private String gender;
        private Integer age;

        // 省略getter和setter方法


}
