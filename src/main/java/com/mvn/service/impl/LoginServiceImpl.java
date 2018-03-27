package com.mvn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.mvn.dao.LoginMapper;
import com.mvn.model.Manager;
import com.mvn.model.User;
import com.mvn.service.LoginService;

/**
 *
 *@author cz
 *@date 2018年3月25日 上午9:43:26
 *
 *
 */
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginMapper loginMapper;

	@Override
	public List<User> loginForUser(JSONObject param) {
		return loginMapper.loginForUser(param);
	}
	

	@Override
	public List<Manager> loginForManager(JSONObject param) {
		return loginMapper.loginForManager(param);
	}

	

}
