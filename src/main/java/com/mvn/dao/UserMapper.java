package com.mvn.dao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.mvn.model.User;

public interface UserMapper {
	
	/**
	 * 查询所有用户
	 * 
	 * @param params
	 * @return
	 */
	public List<User> selectAllUser(JSONObject params);
	
	/**
	 * 根据id查询指定用户
	 * 
	 * @param id
	 * @return
	 */
	public List<User> selectUserById(Integer id);
	
	/**
	 * 保存用户信息
	 * 
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户信息
	 * 
	 * @param id
	 */
	public void deleteUser(Integer id);

	/**
	 * 查询数据条数
	 * 
	 * @param params
	 * @return
	 */
	public List<User> countUser(JSONObject params);


}
