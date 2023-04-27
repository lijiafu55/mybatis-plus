package com.xss;/*
 *@ 2023， 04， 27， 21，52
 *@ 15303   Lijiafu55
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//判断空值
public class EmptyNull {
    @Autowired
    private UserMapper userMapper;

    @Test
    void isNull() throws Exception {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断name字段有没有空值
        lambdaQueryWrapper.isNull(User::getName);
        userMapper.selectList(lambdaQueryWrapper).forEach(user -> System.out.println(user));
    }

    @Test
    void isNotNull() throws Exception {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断name字段有没有不为空值的数据
        lambdaQueryWrapper.isNotNull(User::getName);
        userMapper.selectList(lambdaQueryWrapper).forEach(user -> System.out.println(user));
    }

}
