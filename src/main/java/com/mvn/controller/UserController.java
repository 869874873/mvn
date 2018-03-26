package com.mvn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mvn.model.User;
import com.mvn.service.UserService;

/**
 *
 * @author cz
 * @date 2018年3月25日 上午9:35:43
 *
 *
 */
@Controller
@RequestMapping("/ctrl/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户（含分页）
	 * 
	 * @param page
	 * @param rows
	 * @param paramName
	 * @param createTime
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllUser")
	public JSONObject selectAllUser(@RequestParam(required = false, defaultValue = "1") Integer page, // 第几页
			@RequestParam(required = false, defaultValue = "10") Integer rows, // 页数大小
			@RequestParam(required = false, defaultValue = "") String name,
			@RequestParam(required = false, defaultValue = "") String createTime) {
		JSONObject params = new JSONObject();
		params.put("pageSize", rows);
		params.put("name", name);
		params.put("pageIndex", (page - 1) * rows);
		List<User> selectAllUser = userService.selectAllUser(params);
		JSONObject result = new JSONObject();
		List<User> countUser = null;
		result.put("rows", selectAllUser);
		if (name.equals(""))
			countUser = userService.countUser(null);
		else
			countUser = userService.countUser(params);
		result.put("total", countUser.size());
		return result;
	}

	/**
	 * 删除一条用户信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteUser")
	public JSONObject deleteUser(@RequestParam(required = false, defaultValue = "") Integer id) {
		userService.deleteUser(id);
		JSONObject obj = new JSONObject();
		obj.put("success", true);
		obj.put("msg", "删除成功！");
		return obj;
	}

	/**
	 * 根据id查询指定信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectUserById")
	public JSONObject selectUserById(@RequestParam(required = false, defaultValue = "") Integer id) {
		List<User> selectUserById = userService.selectUserById(id);
		JSONObject obj = new JSONObject();
		obj.put("success", true);
		obj.put("rows", selectUserById);
		return obj;
	}

	/**
	 * 保存or更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveOrUpdateUser")
	public JSONObject saveOrUpdateUser(User user) {
		userService.saveOrUpdateUser(user);
		JSONObject obj = new JSONObject();
		obj.put("success", true);
		obj.put("msg", "保存成功");
		return obj;
	}
}
