package com.xss;/*
 *@ 2023， 04， 27， 20，43
 *@ 15303   Lijiafu55
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//模糊查询测试类
@SpringBootTest
public class LikeTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    // todo notlike 相反
    void like(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //只要name里面包含有J全部查询出来
        lambdaQueryWrapper.like(User::getName,"J");
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        userList.forEach(user-> System.out.println(user));
        /*
        Preparing: SELECT id,name,age,email FROM tb_user WHERE (name LIKE ?)
        ==> Parameters: %J%(String)
        <==    Columns: id, name, age, email
        <==        Row: 1, Jone, 18, test1@baomidou.com
        <==        Row: 2, Jack, 20, test2@baomidou.com
        <==      Total: 2
         */

    }
    //左模糊匹配
    @Test
    void likeLeft(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //表示左边是不确定的，最后面是确定的e
        lambdaQueryWrapper.likeLeft(User::getName,"e");
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        userList.forEach(user-> System.out.println(user));
        /*
        ==>  Preparing: SELECT id,name,age,email FROM tb_user WHERE (name LIKE ?)
        ==> Parameters: %e(String)
        <==    Columns: id, name, age, email
        <==        Row: 1, Jone, 18, test1@baomidou.com
        <==        Row: 5, Billie, 24, test5@baomidou.com
        <==      Total: 2
         */
    }
    //右模糊匹配
    @Test
    void likeRight(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //表示右边是不确定的，最前面是确定的J
        lambdaQueryWrapper.likeRight(User::getName,"J");
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        userList.forEach(user-> System.out.println(user));
        /*
         * Preparing: SELECT id,name,age,email FROM tb_user WHERE (name LIKE ?)
         * ==> Parameters: J%(String)
         */
    }


}
