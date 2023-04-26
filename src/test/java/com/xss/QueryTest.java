package com.xss;/*
 *@ 2023， 04， 26， 22，20
 *@ 15303   Lijiafu55
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

//测试类
@SpringBootTest
public class QueryTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void eq() {
        //创建QueryWrapper条件查询对象
        QueryWrapper<User> query_wp = new QueryWrapper<>();
        // 设置查询条件 指定查询的字段与匹配的值
        query_wp.eq("name", "ww");
        //进行条件查询
        User user = userMapper.selectOne(query_wp);
        System.out.println(user);
    }

    @Test
        //Lambda
    void eq2() {
        //创建LambdaQueryWrapper条件查询对象
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件 指定查询的User::getName字段与匹配的值
        lambdaQueryWrapper.eq(User::getName, "ww");
        //得到结果
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }

    @Test
    void isNull() {
        //这样找不到值，本意是查找全部可惜拼接是这样的
        /*
        Preparing: SELECT id,name,age,email FROM tb_user WHERE (name = ?)
        ==> Parameters: (String)
         */
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //设置查询条件 指定查询的User::getName字段与匹配的值
        lambdaQueryWrapper.eq(User::getName, null);
        //得到结果
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
    }

    @Test
    //单条件查询
    void isNull2() {
        /*
        ==>  Preparing: SELECT id,name,age,email FROM tb_user WHERE (name = ?)
        ==> Parameters: ww(String)
        <==    Columns: id, name, age, email
        <==        Row: 8, ww, 14, ww@gmail
        <==      Total: 1
         */
//        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        String name = "ww";
//        //设置查询条件 指定查询的User::getName字段与匹配的值
//        lambdaQueryWrapper.eq(name != null, User::getName, name);
//        //得到结果
//        User user = userMapper.selectOne(lambdaQueryWrapper);
//        System.out.println(user);

        //下方是查询条件null返回所有
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = null;
        //设置查询条件 指定查询的User::getName字段与匹配的值
        lambdaQueryWrapper.eq(name != null, User::getName, name);
        //得到结果
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(user -> System.out.println(user));

    }
    @Test
    void allEq(){
       LambdaQueryWrapper<User>  lambdaQueryWrapper = new LambdaQueryWrapper<>();
       lambdaQueryWrapper.eq(User::getName, "ww");
       lambdaQueryWrapper.eq(User::getAge, 14);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        System.out.println(user);
        /*
        Preparing: SELECT id,name,age,email FROM tb_user WHERE (name = ? AND age = ?)
         */
    }
    @Test
    void allEq2(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","ww");
        hashMap.put("age",14);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(hashMap,false);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
        /*
        Preparing: SELECT id,name,age,email FROM tb_user WHERE (name = ? AND age = ?)
         */
    }
}
