package com.xss.Controller;

import com.xss.Dao.User;
import com.xss.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
  @ 2023， 04， 26， 10，09
  @ 15303  MP
  @ 15303  com.xss.Controller 10:09
*/
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/getusers")
    public List<User> selectList() {
        List<User> users = userService.selectList();
        return users;
    }


}
