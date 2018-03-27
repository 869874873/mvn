package com.mvn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mvn.dao.UserMapper;
import com.mvn.model.User;
import com.mvn.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;


	@Override
	public List<User> selectUserById(Integer id) {
		List<User> selectUserById = userMapper.selectUserById(id);
		return selectUserById;
	}

	@Override
	public void saveOrUpdateUser(User user) {
		if(user.getId()==null){
			userMapper.insertUser(user);
		}else{
			userMapper.updateUser(user);
		}
	}


	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteUser(id);
	}

	@Override
	public List<User> selectAllUser(JSONObject params) {
		List<User> selectAllUser = userMapper.selectAllUser(params);
		return selectAllUser;
	}

	@Override
	public List<User> countUser(JSONObject params) {
		List<User> countUser = userMapper.countUser(params);
		return countUser;
	}



}
