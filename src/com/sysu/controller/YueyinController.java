package com.sysu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.pojo.MovieOrder;
import com.sysu.pojo.User;
import com.sysu.pojo.Yueyin;
import com.sysu.service.OrderService;
import com.sysu.service.UserService;
import com.sysu.service.YueyinService;
import com.sysu.utils.BeansUtils;
import com.sysu.utils.ConstantUtils;
import com.sysu.utils.IpUtil;
import com.sysu.utils.JsonUtils;

@Controller
@RequestMapping(value="/yueyin")
public class YueyinController {
	private static Logger logger = Logger.getLogger(UserController.class);
	private String separatorString = "'#'";
	
	@Autowired
	private UserService userService;
	@Autowired
	private YueyinService yueyinService;
	@Autowired
	private OrderService orderService;
	
	
	private List<Map<String, Object>> changeListToMap(List<Yueyin> list, String[] ignoreKey) {
		List<Map<String, Object>> ordersList = new LinkedList<Map<String, Object>>();
		for (Yueyin order : list) {
			Map<String, Object> map = changeType(order);
			if (ignoreKey != null) {
				for (int i = 0; i < ignoreKey.length; i++) {
					map.remove(ignoreKey[i]);
				}
			}
			ordersList.add(map);
		}
		return ordersList;
	}
	
	private Map<String, Object> changeType(Yueyin yueyin) {
		Map<String, Object> yueyinMap = BeansUtils.transBean2Map(yueyin);
		String image = userService.getUser(yueyin.getUsername()).getImage();
		yueyinMap.put("image", image);
		String[] friends = yueyin.getFriends().split(separatorString);
		List<Map<String, Object>> firends = new LinkedList<Map<String, Object>>();
		for (int i = 0; i < friends.length; i++) {
			if ("".endsWith(friends[i])) {
				continue;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("username", friends[i]);
			map.put("image", userService.getUser(friends[i]).getImage());
			firends.add(map);
		}
		yueyinMap.put("friends", firends);
		return yueyinMap;
	}
	
	@RequestMapping(value =  {"", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allYueyins(HttpServletRequest request) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			String username = userInfo.getUsername();
			if (userService.isExist(username) < 1) {
		        map.put("msg", username + "用户不存在");
		        map.put("data", "");  
		        map.put("status", "0");
		        return map;
			}
			List<Yueyin> listOrders = yueyinService.getAllYueyin();
	        map.put("msg", "");
	        map.put("data", changeListToMap(listOrders, null));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("获取用户约影列表异常", e);
			map.put("msg", "获取用户约影列表异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> userYueyins(HttpServletRequest request) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			String username = userInfo.getUsername();
			if (userService.isExist(username) < 1) {
		        map.put("msg", username + "用户不存在");
		        map.put("data", "");  
		        map.put("status", "0");
		        return map;
			}
			List<Yueyin> listOrders = yueyinService.getYueyinByUserName(username);
	        map.put("msg", "");
	        map.put("data", changeListToMap(listOrders, null));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("获取用户约影列表异常", e);
			map.put("msg", "获取用户约影列表异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
	
	@RequestMapping(value = "/{yueyin_id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> detailYueyin(HttpServletRequest request,
    		@PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			Yueyin yueyin = yueyinService.selectYueyinById(yueyin_id);
			if (yueyin != null) {
		        map.put("msg", "");
		        map.put("data", changeType(yueyin));  
		        map.put("status", "1");
			} else {
		        map.put("msg", "获取约影信息失败，不存在该约影信息");
		        map.put("data", "");
		        map.put("status", "0");  
			}
			return map;
		} catch (Exception e) {
			logger.error("获取约影信息异常", e);
			map.put("msg", "获取约影信息异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> makeYueyin(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(required = true, value = "order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			String username = userInfo.getUsername();
			String ipString = IpUtil.getIpAddress(request);
			String cityString = IpUtil.getCityByIp(ipString);
			if (!"广州".equals(cityString)) {
				map.put("msg", "用户所处位置不在广州，当前只开通广州地区的约影功能");
		        map.put("data", "");  
		        map.put("status", "0");
		        return map;
			}
			
			if (userService.isExist(username) < 1) {
		        map.put("msg", username + "用户不存在");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}

			MovieOrder order = orderService.getOrdersById(order_id);
			if (order == null) {
				map.put("msg", order_id + "订单不存在，无法发起约影");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			if (order.getHasYueyin() == 1) {
				map.put("msg", order_id + "订单已结发起过约影，无法重复操作");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			order.setHasYueyin(1);
			int res = orderService.updateOrder(order);
			if (res < 1) {
				map.put("msg", order_id + "发起约影失败");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			
			Yueyin yueyin = new Yueyin();
			yueyin.setUsername(username);
			yueyin.setOrderId(order_id);
			yueyin.setNum(order.getNum());
			yueyin.setStatus(1);
			yueyin.setFriends("");
			yueyin.setCinemaName(order.getCinemaName());
			yueyin.setMovieName(order.getMovieName());
			yueyin.setShowTime(order.getShowTime());
			yueyin.setLeaveNum(order.getNum() - 1);

			res = yueyinService.insertYueyin(yueyin);
			System.out.println(yueyin.getId());
			if (res > 0) {
				HashMap<String, Object> tem = new HashMap<String, Object>();
				tem.put("yueyin_id", yueyin.getId());
		        map.put("msg", "");
		        map.put("data", tem);
		        map.put("status", "1");
			} else {
		        map.put("msg", "发起约影失败");
		        map.put("data", "");
		        map.put("status", "0");  
			}
			return map;
		} catch (Exception e) {
			logger.error("发起约影异常", e);
			map.put("msg", "发起约影异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
	
    @RequestMapping(value = "/{yueyin_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteYueyin(HttpServletRequest request,
    		@PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			int res = yueyinService.deleteYueyinById(yueyin_id);
			if (res > 0) {
		        map.put("msg", "");
		        map.put("status", "1");
			} else {
		        map.put("msg", "删除约影信息失败");
		        map.put("status", "0");  
			}
	        map.put("data", "");  
			return map;
		} catch (Exception e) {
			logger.error("删除约影信息异常", e);
			map.put("msg", "删除约影信息异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
    @RequestMapping(value = "/{yueyin_id}/enter", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> leaveYueyin(HttpServletRequest request,
    		@PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			String username = userInfo.getUsername();
			Yueyin yueyin = yueyinService.selectYueyinById(yueyin_id);
			if (yueyin == null) {
		        map.put("msg", "退出约影失败，不存在该约影信息");
		        map.put("data", "");
		        map.put("status", "0");
		        return map;
			}
			
			String[] friends = StringUtils.split(yueyin.getFriends(), separatorString);
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(friends));
			if (!list.remove(username)) {
				map.put("msg", "退出约影失败，" + username + "未加入该约影");
		        map.put("data", "");
		        map.put("status", "0");
		        return map;
			}
			String newFriendsString = StringUtils.join(list.toArray(), separatorString);
			yueyin.setFriends(newFriendsString);
			yueyin.setLeaveNum(yueyin.getLeaveNum() + 1);
			
			int res = yueyinService.updateYueyinById(yueyin);
			if (res > 0) {
		        map.put("msg", "");
		        map.put("status", "1");
			} else {
		        map.put("msg", "退出约影失败");
		        map.put("status", "0");  
			}
	        map.put("data", "");  
			return map;
		} catch (Exception e) {
			logger.error("退出约影异常", e);
			map.put("msg", "退出约影异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
    @RequestMapping(value = "/{yueyin_id}/enter", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> enterYueyin(HttpServletRequest request,
    		@PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			String username = userInfo.getUsername();
			Yueyin yueyin = yueyinService.selectYueyinById(yueyin_id);
			if (yueyin == null) {
		        map.put("msg", "加入约影失败，不存在该约影信息");
		        map.put("data", "");
		        map.put("status", "0");
		        return map;
			}
			if (username.equals(yueyin.getUsername())) {
				map.put("msg", "加入约影失败，自己不需要加入自己的约影信息");
		        map.put("data", "");
		        map.put("status", "0");
		        return map;
			}
			
			String[] friends = StringUtils.split(yueyin.getFriends(), separatorString);
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(friends));
			if (yueyin.getLeaveNum() <= 0) {
				map.put("msg", "加入约影失败，该约影人数已满");
		        map.put("data", "");
		        map.put("status", "0");
		        return map;
			} else if (list.contains(username)) {
				map.put("msg", "无需重复加入");
		        map.put("data", "");
		        map.put("status", "0");
		        return map;
			} else {
				list.add(username);
			}
			String newFriendsString = StringUtils.join(list.toArray(), separatorString);
			yueyin.setFriends(newFriendsString);
			yueyin.setLeaveNum(yueyin.getLeaveNum() - 1);
			
			int res = yueyinService.updateYueyinById(yueyin);
			if (res > 0) {
		        map.put("msg", "");
		        map.put("status", "1");
			} else {
		        map.put("msg", "加入约影失败");
		        map.put("status", "0");  
			}
	        map.put("data", "");  
			return map;
		} catch (Exception e) {
			logger.error("加入约影异常", e);
			map.put("msg", "加入约影异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
}
