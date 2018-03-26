package com.mvn.dao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.mvn.model.Manager;
import com.mvn.model.User;

/**
 *
 * @author cz
 * @date 2018年3月25日 上午9:39:02
 *
 *
 */
public interface LoginMapper {

	/**
	 * 登录方法(用户)
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List<User> loginForUser(JSONObject param);

	/**
	 * 登录方法(管理员)
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List<Manager> loginForManager(JSONObject param);

	/**
	 * 登出方法
	 */
	public void logout();

}
