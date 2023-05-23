package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUser();
	User getUserById(long userId);
	User updateUser(User user, long userId);
	void deleteUser(long userId);
	User getUserByUserName(String userName);
	User loginUser(User user);
}
