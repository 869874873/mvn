package com.mvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvn.model.Manager;
import com.mvn.service.ManagerService;

@Controller
@RequestMapping("/ctrl/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@ResponseBody
	@RequestMapping("/selectAllManager")
	public List<Manager> selectAllManager(){
		List<Manager> selectAllManager = managerService.selectAllManager();
		return selectAllManager;
	}

}
