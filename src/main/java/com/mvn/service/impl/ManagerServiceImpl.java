package com.mvn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvn.dao.ManagerMapper;
import com.mvn.model.Manager;
import com.mvn.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public List<Manager> selectAllManager() {
		List<Manager> selectAllManager = managerMapper.selectAllManager();
		return selectAllManager;
	}

}
