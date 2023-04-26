package com.xss.Dao;

import com.baomidou.mybatisplus.annotation.TableField;
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
        //表字段映射
        @TableField("last_name")
        private String lastName;
        private String email;

        private String gender;
        private Integer age;

        //假如数据库有字段desc，mysql关键字的话
        // 关键字查询通过注解让他变成普通字段
        //@TableField("`desc`")


        //假如查询不想看到年龄的话通过
        //@TableField(select = false)放到不想查询的字段属性上


        //假如查询数据库没有的字段是实体类自己定义的例如登录状态...
        // @TableField(exist = false)
        


}
