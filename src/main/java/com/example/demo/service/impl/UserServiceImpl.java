package com.example.demo.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JsonListUtil;
import com.google.common.collect.Lists;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Value("${chenyong.cyy.key}")
	private String key;
	@Value("${com.cyy.value}")
	private String randomValue;

	@Override
	public List<User> testRedis() throws Exception {
		List<User> users = Lists.newArrayList();
		boolean hasKey = stringRedisTemplate.hasKey(key);
		if(hasKey) {
			users = JsonListUtil.jsonToList(stringRedisTemplate.opsForValue().get(key), User.class);
		}else {
			users = userRepository.findAll();
			stringRedisTemplate.opsForValue().set(key, JsonListUtil.listToJson(users),10,TimeUnit.SECONDS);
		}
		return users;
	}

	@Override
	public String getRandomValue() {
		return randomValue;
	}

}
