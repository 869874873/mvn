package com.mvn.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.mvn.model.Manager;
import com.mvn.model.User;

/**
 *
 * @author cz
 * @date 2018年3月25日 上午9:42:36
 *
 *
 */
public interface LoginService {

	/**
	 * 登录系统(用户)
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List<User> loginForUser(JSONObject param);

	/**
	 * 登录系统(管理员)
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List<Manager> loginForManager(JSONObject param);

}
