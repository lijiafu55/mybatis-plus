package com.xss;

import com.xss.Dao.User;
import com.xss.Mapper.EmployeeMapper;
import com.xss.Mapper.UserMapper;
import com.xss.Service.EmployeeService;
import com.xss.Service.Impl.UserServiceImpl;
import com.xss.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeMapper em;
	@Test
	void selectList(){
		userMapper.selectList(null).forEach(user -> System.out.println(user));
	}

	// 添加数据
	@Test
	void insert(){
		User user = new User();
		user.setId(6L);
		user.setName("zhangsan");
		user.setAge(25);
		user.setEmail("zhangsan@gmail.com");
		userMapper.insert(user);
	}
	//删除
	@Test
	void deleteOne(){
		userMapper.deleteById(6L);
	}
	@Test
	// 修改
	void updateById(){
		User user = new User();
		user.setId(6L);
		user.setName("张三");
		user.setAge(27);
		user.setEmail("张三@gmail");
		userMapper.updateById(user);
	}
	//根据id查询
	//@Test
	void selectById(Long id){
		User user = userMapper.selectById(id);
		System.out.println(user);
	}
	@Test
	void runselectById(){
		selectById(6L);
	}
	//userService插入服务
	@Test
	void insertService(){
		User user = new User();
		user.setId(8L);
		user.setName("ww");
		user.setAge(14);
		user.setEmail("ww@gmail");
		userService.save(user);
	}
	//userService删除服务
	@Test
	void delectService(){
		userService.removeById(7L);
	}
	//userService修改
	@Test
	void updateService(){
		User user = new User();
		user.setId(7L);
		user.setName("black");
		user.setAge(21);
		user.setEmail("black@gmail");
		userService.updateById(user);
	}
	//userService查询
	@Test
	void selectService(){
		userService.selectList().forEach(user -> System.out.println(user));
	}

	//测试自己编写的方法
	@Test
	void selectByName(){
		User user = userMapper.selectByName("Tom");
		System.out.println(user.getName().equals("Tom") ? "成功找到Tom" :"没有找到Tom");
	}

	//测试em
	@Test
	void select_Em_List(){
		em.selectList(null).forEach(em -> System.out.println(em));
	}
}
