package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	public List<User> testRedis() throws Exception;
	
	public String getRandomValue();
}
