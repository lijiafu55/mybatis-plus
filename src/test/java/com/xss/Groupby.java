package com.xss;/*
 *@ 2023， 04， 28， 20，36
 *@ 15303   Lijiafu55
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest

public class Groupby {
    @Autowired
    private UserMapper userMapper;
    // sql  SELECT age,COUNT(*) AS tb_age_count FROM tb_user GROUP BY age
    /**
     * age	tb_age_count
     * 18	1
     * 20	1
     * 28	1
     * 21	1
     * 24	1
     * 14	1
     */

    @Test
    //分组查询
    void groupBy(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //分组字段
        queryWrapper.groupBy("age");
        //查询字段
        queryWrapper.select("age","COUNT(*) AS tb_age_count");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(map -> System.out.println(map.toString()));
        /*
         * ==>  Preparing: SELECT age,COUNT(*) AS tb_age_count FROM tb_user GROUP BY age
         * ==> Parameters:
         * <==    Columns: age, tb_age_count
         * <==        Row: 18, 1
         * <==        Row: 20, 1
         * <==        Row: 28, 1
         * <==        Row: 21, 1
         * <==        Row: 24, 1
         * <==        Row: 14, 1
         * <==      Total: 6
         */

    }
    @Test
    //聚合查询 对分组过后的再次分组
    // SELECT age,COUNT(*) AS tb_age_count FROM tb_user GROUP BY age HAVING tb_age_count >=2
    void groupBy2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //分组字段
        queryWrapper.groupBy("age");
        //查询字段
        queryWrapper.select("age","COUNT(*) AS tb_age_count");
        queryWrapper.having("tb_age_count>=2");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);
        /*
         *   Preparing: SELECT age,COUNT(*) AS tb_age_count FROM tb_user GROUP BY age HAVING tb_age_count>=2
         * ==> Parameters:
         * <==      Total: 0
         */
    }


}
