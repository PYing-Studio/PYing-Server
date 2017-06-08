package com.sysu.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sysu.utils.BeansUtils;
import com.sysu.utils.Md5Encrypt;
import com.sysu.pojo.User;
import com.sysu.service.UserService;
import com.sysu.utils.ConstantUtils;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	private static final String key = "pyin";

	@Autowired
	private UserService userService;

	// http://localhost:8080/api/user/login?password=string&username=string
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
		// if ("".equals(user.getPhone())) {
		// map.put("status", "0");
		// map.put("msg", "手机不能为空，或者格式错误");
		// }
		if ("".equals(user.getNickname())) {
			user.setNickname("泡影用户");
		}
		return map;
	}

	// http://localhost:8080/api/user/register?email=string&nickname=string&password=string&phone=string&username=string
	@RequestMapping(value = "register", method = RequestMethod.POST)
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
			user.setPassword(Md5Encrypt.md5(user.getPassword() + key));
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

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUser(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			HttpSession session = request.getSession();
			User userinfo = (User) session
					.getAttribute(ConstantUtils.USER_INFO);
			User user = userService.getUser(userinfo.getUsername());
			Map<String, Object> beanMap = BeansUtils.transBean2Map(user);
			beanMap.remove("id");
			beanMap.remove("password");
			map.put("status", "1");
			map.put("data", beanMap);
			map.put("msg", "");
			return map;
		} catch (Exception e) {
			logger.error("退出登录异常" + e);
			map.put("status", "0");
			map.put("msg", "退出登录异常");
			return map;
		}
	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> setImage(
			HttpServletRequest request,
			@RequestParam(required = true, value = "image") MultipartFile imageFile) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			HttpSession session = request.getSession();
			User userinfo = (User) session
					.getAttribute(ConstantUtils.USER_INFO);
			User user = userService.getUser(userinfo.getUsername());
			String imgUrl = "";
			if (!imageFile.isEmpty()) {
				String OriginalFilename = imageFile.getOriginalFilename();
				String extensionName = OriginalFilename.indexOf(".") != -1 ? OriginalFilename
						.substring(OriginalFilename.lastIndexOf(".") + 1,
								OriginalFilename.length()) : null;
				// String extensionName = OriginalFilename
				// .substring(OriginalFilename.lastIndexOf("."));
				if (extensionName != null) {// 判断文件类型是否为空
					if ("GIF".equals(extensionName.toUpperCase())
							|| "PNG".equals(extensionName.toUpperCase())
							|| "JPG".equals(extensionName.toUpperCase())) {
						String logImageName = user.getUsername() + "." + extensionName;
						String realPath=request.getSession().getServletContext().getRealPath(File.separator);
						String preimagePath = File.separator + "userImage" + File.separator + logImageName;
						FileCopyUtils.copy(imageFile.getBytes(), new File(
								realPath + preimagePath));
						imgUrl = request.getScheme() + "://"
								+ ConstantUtils.SERVER_IP + ":" + request.getServerPort() + request.getContextPath() + "/userImage/" + logImageName;
					} else {
						map.put("status", "0");
						map.put("msg", "不是我们想要的文件类型,请按要求重新上传");
						map.put("data", "");
						return map;
					}
				} else {
					map.put("status", "0");
					map.put("msg", "文件类型为空,请按要求重新上传");
					map.put("data", "");
					return map;
				}
			} else {
				map.put("status", "0");
				map.put("data", "");
				map.put("msg", "没有找到相对应的文件");
				return map;
			}
			map.put("status", "1");
			map.put("data", imgUrl);
			map.put("msg", "");
			return map;
		} catch (Exception e) {
			logger.error("上传图片异常" + e);
			map.put("status", "0");
			map.put("msg", "上传图片异常");
			map.put("data", "");
			return map;
		}
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateUser(HttpServletRequest request,
			@RequestBody User user) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			HttpSession session = request.getSession();
			User userinfo = (User) session
					.getAttribute(ConstantUtils.USER_INFO);
			user.setId(userinfo.getId());
			user.setUsername(userinfo.getUsername());
			user.setPassword(user.getPassword());
			map = checkUserForm(user);
			if ("0".equals(map.get("status"))) {
				return map;
			}
			int res = userService.updateUser(user);
			if (res > 0) {
				map.put("status", "1");
				map.put("msg", "");
			} else {
				map.put("status", "0");
				map.put("msg", "用户信息更新失败");
			}
			return map;
		} catch (Exception e) {
			logger.error("更新用户信息异常" + e);
			map.put("status", "0");
			map.put("msg", "更新用户信息异常");
			return map;
		}
	}

}
