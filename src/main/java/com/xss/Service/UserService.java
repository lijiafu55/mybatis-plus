package com.xss.Service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.xss.Dao.User;

import java.util.List;


/**
 * public interface UserService {
 *     List<User> selectList();
 * }
 */
public interface UserService extends IService<User> {
    List<User> selectList();
}
