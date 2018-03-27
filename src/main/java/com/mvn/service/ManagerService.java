package com.mvn.service;

import java.util.List;

import com.mvn.model.Manager;

public interface ManagerService {
	
	/**
	 * 查询所有管理员信息
	 * @return
	 */
	public List<Manager> selectAllManager();

}
