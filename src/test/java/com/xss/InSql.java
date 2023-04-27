package com.xss;/*
 *@ 2023， 04， 27， 22，10
 *@ 15303   Lijiafu55
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//多元化sql
// TODO notInSql 相反
public class InSql {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insql(){
        // TODO  com.xss.QueryIn -->in()补充
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge,"18,20,21");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));
        /*
         *   Preparing: SELECT id,name,age,email FROM tb_user WHERE (age IN (18,20,21))
         * ==> Parameters:
         * <==    Columns: id, name, age, email
         * <==        Row: 1, Jone, 18, test1@baomidou.com
         * <==        Row: 2, Jack, 20, test2@baomidou.com
         * <==        Row: 4, Sandy, 21, test4@baomidou.com
         * <==      Total: 3
         */
    }
    //子查询拼接
    @Test
    void inSql(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.inSql(User::getAge,"select age from tb_user where age>20");
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));
        /*
         * Preparing: SELECT id,name,age,email FROM tb_user WHERE (age IN (select age from tb_user where age>20))
         * ==> Parameters:
         * <==    Columns: id, name, age, email
         * <==        Row: 3, Tom, 28, test3@baomidou.com
         * <==        Row: 4, Sandy, 21, test4@baomidou.com
         * <==        Row: 5, Billie, 24, test5@baomidou.com
         * <==      Total: 3
         */
    }

}
