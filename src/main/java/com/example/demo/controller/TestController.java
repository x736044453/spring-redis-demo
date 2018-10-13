package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.google.common.collect.Lists;

@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	public Object test() {
		logger.info("-----------");
		List<User> users = Lists.newArrayList();
		try {
			users = userService.testRedis();
		} catch (Exception e) {
			logger.error("-----{}",e);
		}
		return users;
	}
	
	@RequestMapping("/test1")
	public String getRandomValue() {
		return userService.getRandomValue();
	}

}
