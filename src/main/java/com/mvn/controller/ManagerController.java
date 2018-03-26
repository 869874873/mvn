package com.mvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvn.model.Manager;
import com.mvn.service.ManagerService;

/**
 *
 * @author cz
 * @date 2018年3月25日 上午9:35:43
 *
 *
 */
@Controller
@RequestMapping("/ctrl/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	/**
	 * 查询所有管理员信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAllManager")
	public List<Manager> selectAllManager() {
		List<Manager> selectAllManager = managerService.selectAllManager();
		return selectAllManager;
	}

}
