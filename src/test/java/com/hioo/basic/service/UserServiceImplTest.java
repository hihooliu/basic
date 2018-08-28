package com.hioo.basic.service;

import com.hioo.basic.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Autowired
	private UserServiceImpl userService;

	@Test
	public void getUserById() throws Exception {
		User user = userService.getUserById(1);
		System.out.println(user);
	}

	@Test
	public void addUser() throws Exception {
		User user = new User();
//		user.setId(1);
		user.setAge(18);
		user.setUserName("hihoo");
		user.setPassword("1123");
		boolean success = userService.addUser(user);
		Assert.assertEquals(true, success);
	}

}