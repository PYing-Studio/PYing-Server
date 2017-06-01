package com.sysu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.utils.Md5Encrypt;
import com.sysu.pojo.User;
import com.sysu.service.UserService;
import com.sysu.utils.ConstantUtils;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	private static final String key = "pyin";

	@Autowired
	private UserService userService;

	// http://localhost:8080/PYin_Server/user/login?password=string&username=string
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(
			@RequestParam(value = "username", required = true, defaultValue = "") String username,
			@RequestParam(value = "password", required = true, defaultValue = "") String password,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
				map.put("status", "0");
				map.put("msg", "帐号密码不能为空");
				return map;
			}
			User user = userService.login(username, password + key);
			if (user != null) { // 登录成功，记录session
				HttpSession session = request.getSession();
				session.setAttribute(ConstantUtils.USER_INFO, user);
				map.put("status", "1");
				map.put("msg", "");
				return map;
			} else {
				map.put("status", "0");
				map.put("msg", "帐号密码错误");
				return map;
			}
		} catch (Exception e) {
			logger.error("登录异常", e);
			map.put("status", "0");
			map.put("msg", "登录异常");
			return map;
		}
	}

	@RequestMapping(value = "logout")
	@ResponseBody
	public Map<String, String> logout(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(ConstantUtils.USER_INFO);
			map.put("status", "1");
			map.put("msg", "");
			return map;
		} catch (Exception e) {
			logger.error("退出登录异常" + e);
			map.put("status", "0");
			map.put("msg", "退出登录异常");
			return map;
		}
	}

	private Map<String, String> checkUserForm(User user) {
		Map<String, String> map = new HashMap<String, String>();
		if ("".equals(user.getEmail())) {
			map.put("status", "0");
			map.put("msg", "邮箱不能为空，或者格式错误");
		}
		if ("".equals(user.getPassword())) {
			map.put("status", "0");
			map.put("msg", "密码不能为空，或者格式错误");
		}
		if ("".equals(user.getUsername())) {
			map.put("status", "0");
			map.put("msg", "用户名不能为空，或者格式错误");
		}
		if ("".equals(user.getPhone())) {
			map.put("status", "0");
			map.put("msg", "手机不能为空，或者格式错误");
		}
		if ("".equals(user.getNickname())) {
			user.setNickname("泡影用户");
		}
		return map;
	}

	// http://localhost:8080/PYin_Server/user/register?email=string&nickname=string&password=string&phone=string&username=string
	@RequestMapping(value = "register")
	@ResponseBody
	public Map<String, String> register(
			@RequestParam(value = "username", required = true, defaultValue = "") String username,
			@RequestParam(value = "password", required = true, defaultValue = "") String password,
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "phone", required = true, defaultValue = "") String phone,
			@RequestParam(value = "nickname", required = true, defaultValue = "") String nickname,
			HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			User user = new User();
			user.setEmail(email);
			user.setNickname(nickname);
			user.setPassword(password);
			user.setPhone(phone);
			user.setUsername(username);
			map = checkUserForm(user);
			if ("0".equals(map.get("status"))) {
				return map;
			}
			if (userService.isExist(user.getUsername()) > 0) {
				map.put("status", "0");
				map.put("msg", user.getUsername() + "已经存在，请修改账户！");
				return map;
			}
			user.setPassword(Md5Encrypt.md5(password + key));
			int ret = userService.insertUser(user);
			if (ret > 0) {
				map.put("status", "1");
				map.put("msg", "");
			} else {
				map.put("status", "0");
				map.put("msg", "用户无法添加到数据库，注册失败");
			}
			return map;
		} catch (Exception e) {
			logger.error("toAddManager异常", e);
			map.put("status", "0");
			map.put("msg", "注册异常");
			return map;
		}
	}

}
