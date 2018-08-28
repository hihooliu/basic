package com.hioo.basic.service;

import com.hioo.basic.entity.User;

public interface UserService {
	public User getUserById(int userId);

	boolean addUser(User record);
}
