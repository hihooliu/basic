package com.hioo.basic.service;

import com.hioo.basic.dao.UserDao;
import com.hioo.basic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public boolean addUser(User record) {
		int insert = userDao.insert(record);
		if (insert == 1) {
			return true;
		}
		return false;
	}
}
