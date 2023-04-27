package com.xss;/*
 *@ 2023， 04， 27， 22，01
 *@ 15303   Lijiafu55
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
//多条件查询
public class QueryIn {
    @Autowired
    private UserMapper userMapper;

    @Test
    void in(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        //只要包含就输出
        Collections.addAll(arrayList,18,20,22);
        lambdaQueryWrapper.in(User::getAge,arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));
        /*
         *  Preparing: SELECT id,name,age,email FROM tb_user WHERE (age IN (?,?,?))
         * ==> Parameters: 18(Integer), 20(Integer), 22(Integer)
         * <==    Columns: id, name, age, email
         * <==        Row: 1, Jone, 18, test1@baomidou.com
         * <==        Row: 2, Jack, 20, test2@baomidou.com
         * <==      Total: 2
         */
    }
    @Test
    void notin(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        //只要不包含就输出
        Collections.addAll(arrayList,18,20,22);
        lambdaQueryWrapper.notIn(User::getAge,arrayList);
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));
        /*
         *  Preparing: SELECT id,name,age,email FROM tb_user WHERE (age NOT IN (?,?,?))
         * ==> Parameters: 18(Integer), 20(Integer), 22(Integer)
         * <==    Columns: id, name, age, email
         * <==        Row: 3, Tom, 28, test3@baomidou.com
         * <==        Row: 4, Sandy, 21, test4@baomidou.com
         * <==        Row: 5, Billie, 24, test5@baomidou.com
         * <==        Row: 8, ww, 14, ww@gmail
         * <==      Total: 4
         */
    }



}
