package com.xss;/*
 *@ 2023， 04， 28， 20，54
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
public class SortSql {

    @Autowired
    private UserMapper userMapper;
    @Test
    void orderByAsc(){
        //升序
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //优先age排序，其次id
        lambdaQueryWrapper.orderByAsc(User::getAge,User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
        /*
         * Preparing: SELECT id,name,age,email FROM tb_user ORDER BY age ASC,id ASC
         * ==> Parameters:
         * <==    Columns: id, name, age, email
         * <==        Row: 8, ww, 14, ww@gmail
         * <==        Row: 1, Jone, 18, test1@baomidou.com
         * <==        Row: 2, Jack, 20, test2@baomidou.com
         * <==        Row: 4, Sandy, 21, test4@baomidou.com
         * <==        Row: 5, Billie, 24, test5@baomidou.com
         * <==        Row: 3, Tom, 28, test3@baomidou.com
         * <==      Total: 6
         */

    }

    @Test
    void orderByDesc(){
        //降序
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //优先age排序，其次id
        lambdaQueryWrapper.orderByDesc(User::getAge,User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
        /*
         * Preparing: SELECT id,name,age,email FROM tb_user ORDER BY age DESC,id DESC
         * ==> Parameters:
         * <==    Columns: id, name, age, email
         * <==        Row: 3, Tom, 28, test3@baomidou.com
         * <==        Row: 5, Billie, 24, test5@baomidou.com
         * <==        Row: 4, Sandy, 21, test4@baomidou.com
         * <==        Row: 2, Jack, 20, test2@baomidou.com
         * <==        Row: 1, Jone, 18, test1@baomidou.com
         * <==        Row: 8, ww, 14, ww@gmail
         * <==      Total: 6
         */

    }
    @Test
    void orderBy(){
        //自定义
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //boolean condition, boolean isAsc, R column, R... columns
        //升序
        lambdaQueryWrapper.orderBy(true,true,User::getAge);
        //降序
        lambdaQueryWrapper.orderBy(true,false,User::getId);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        System.out.println(users);
        /*
         *  Preparing: SELECT id,name,age,email FROM tb_user ORDER BY age ASC,id DESC
         * ==> Parameters:
         * <==    Columns: id, name, age, email
         * <==        Row: 8, ww, 14, ww@gmail
         * <==        Row: 1, Jone, 18, test1@baomidou.com
         * <==        Row: 2, Jack, 20, test2@baomidou.com
         * <==        Row: 4, Sandy, 21, test4@baomidou.com
         * <==        Row: 5, Billie, 24, test5@baomidou.com
         * <==        Row: 3, Tom, 28, test3@baomidou.com
         * <==      Total: 6
         */

    }
}
