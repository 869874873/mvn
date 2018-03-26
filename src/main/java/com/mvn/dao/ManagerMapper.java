package com.mvn.dao;

import java.util.List;

import com.mvn.model.Manager;

public interface ManagerMapper {
	
	/**
	 * 查询管理员信息
	 * 
	 * @return
	 */
	public List<Manager> selectAllManager();

}
