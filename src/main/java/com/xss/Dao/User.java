package com.xss.Dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//tb——user
@TableName("tb_user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}