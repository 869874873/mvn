package com.mvn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mvn.model.Manager;
import com.mvn.model.User;
import com.mvn.service.LoginService;

/**
 *
 * @author cz
 * @date 2018年3月25日 上午9:35:45
 *
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	/**
	 * 登陆操作
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public JSONObject login(
			@RequestParam(required = false, defaultValue = "") String username, 
			@RequestParam(required = false, defaultValue = "") String password,
			HttpSession session){
		JSONObject param = new JSONObject();
		param.put("name", username);
		param.put("pwd", password);
		List<User> loginForUser = loginservice.loginForUser(param);
		List<Manager> loginForManager = loginservice.loginForManager(param);
		
		JSONObject obj = new JSONObject();
		//如果查出数据在用户表中，赋给token一个值，证明该人身份为普通用户
		if(loginForUser.size() != 0){
			obj.put("success", true);
			session.setAttribute("token", 1);
			session.setAttribute("loginr", loginForUser.get(0).getName());
		}else if(loginForManager.size() != 0){//如果查出数据在管理员表中，则赋值token，用来判定该人身份为管理员
			obj.put("success", true);
			session.setAttribute("token", 0);
			session.setAttribute("loginr", loginForManager.get(0).getFacultyName());
		}else {//都没有，则证明查无此人，进行提示
			obj.put("success", false);
		}
		return obj;
	}
	
	/**
	 * 注销操作
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public JSONObject logout(HttpSession session){
		session.invalidate();
		JSONObject obj = new JSONObject();
		obj.put("success", true);
		obj.put("msg", "注销成功！");
		return obj;
	}
	

}
