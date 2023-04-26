package com.xss.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xss.Dao.User;
import com.xss.Mapper.UserMapper;
import com.xss.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * @ 2023， 04， 26， 10，07
  *@ 15303  MP
  *public class UserServiceImpl implements UserService {
***/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectList() {
        return userMapper.selectList(null);
    }
}
