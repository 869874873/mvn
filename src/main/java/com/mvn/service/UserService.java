package com.mvn.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.mvn.model.User;

public interface UserService {
	
	/**
	 * 查询所有用户信息
	 * 含分页
	 * 
	 * @param params
	 * @return
	 */
	public List<User> selectAllUser(JSONObject params);
	
	/**
	 * 查询指定id用户信息
	 * 
	 * @param id
	 * @return
	 */
	public List<User> selectUserById(Integer id);
	
	/**
	 * 保存或更新用户信息
	 * 
	 * @param user
	 */
	public void saveOrUpdateUser(User user);
	
	/**
	 * 删除用户信息
	 * 
	 * @param id
	 */
	public void deleteUser(Integer id);

	/**
	 * 查询数据总条数
	 * 
	 * @param params
	 * @return
	 */
	public List<User> countUser(JSONObject params);



}
