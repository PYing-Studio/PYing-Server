package com.sysu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sysu.pojo.User;
import com.sysu.service.UserService;
import com.sysu.utils.ConstantUtils;

@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);

	private static final String key = "dadan";
	
	@Autowired
	private UserService userService;

	// superman_luwei_passwd
	@RequestMapping(value = "login")
	public String login(
			@RequestParam(value = "username", required = true ,defaultValue="") String username,
			@RequestParam(value = "password", required = true ,defaultValue="") String password,
			HttpServletRequest request, Model model) {
		try {
			
			if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
				model.addAttribute("retFlag", 1);
				model.addAttribute("errorMessage", "帐号密码不能为空");
				return "jsp/login";
			}
			User user = userService.login(username, password + key);
			if (user != null) { // 登录成功，记录session
				HttpSession session = request.getSession();
				session.setAttribute(ConstantUtils.USER_INFO, user);
				model.addAttribute("userInfo", user);
				return "redirect:/toutiao/toToutiaoOrder.do";
			} else {
				model.addAttribute("retFlag", 1);
				model.addAttribute("errorMessage", "帐号密码错误");
				return "jsp/login";
			}
		} catch (Exception e) {
			logger.error("登录异常", e);
			model.addAttribute("retFlag", 1);
			model.addAttribute("errorMessage", "登录失败，请重试");
			return "jsp/login";
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, Model model) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("userInfo");
			return "jsp/login";
		} catch (Exception e) {
			logger.error("退出登录异常" + e);
			model.addAttribute("retFlag", 1);
			model.addAttribute("errorMessage", "退出登录失败，请重试");
			return "jsp/login";
		}
	}
	
	@RequestMapping(value = "toLogin")
	public String toLogin(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		User userInfo = (User) session.getAttribute("userInfo");
		if (userInfo != null) {
			return "redirect:/toutiao/initOrderToutiao.do";
		}
		return "jsp/login";
	}
}
