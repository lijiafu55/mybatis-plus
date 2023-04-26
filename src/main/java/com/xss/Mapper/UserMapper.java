package com.xss.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xss.Dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByName(String name);
}
