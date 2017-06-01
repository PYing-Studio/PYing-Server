package com.sysu.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.pojo.Order;
import com.sysu.pojo.User;
import com.sysu.service.OrderService;
import com.sysu.service.UserService;
import com.sysu.utils.BeansUtils;
import com.sysu.utils.ConstantUtils;
import com.sysu.utils.DateUtil;


@Controller
public class OrderController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	private  List<Map<String, Object>> changeListType(List<Order> listOrders) {
		List<Map<String, Object>> ordersList = new LinkedList<Map<String, Object>>();
		for (Order order : listOrders) {
			Map<String, Object> map = BeansUtils.transBean2Map(order);
			ordersList.add(map);
		}
		return ordersList;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allOrders(HttpServletRequest request,
    		@RequestParam(required = true, value = "username") String username) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			if (userInfo == null) {
		        map.put("msg", "用户未登录");
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
			List<Order> listOrders = orderService.getOrdersByUsername(username);
	        map.put("msg", "");
	        map.put("data", changeListType(listOrders));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("获取用户订单列表异常", e);
			map.put("msg", "获取用户订单列表异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
	
	@RequestMapping(value = "/{order_id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> detailOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "order_id") @PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			if (userInfo == null) {
		        map.put("msg", "用户未登录");
		        map.put("data", "");  
		        map.put("status", "0");
		        return map;
			}
			Order order = orderService.getOrdersById(order_id);
			if (order != null) {
		        map.put("msg", "");
		        map.put("data", BeansUtils.transBean2Map(order));  
		        map.put("status", "1");
			} else {
		        map.put("msg", "获取订单失败，不存在该订单");
		        map.put("data", "");
		        map.put("status", "0");  
			}
			return map;
		} catch (Exception e) {
			logger.error("获取订单异常", e);
			map.put("msg", "获取订单异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> makeOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "username") String username,
    		@RequestParam(required = true, value = "cinemaId") Integer cinemaId,
    		@RequestParam(required = true, value = "movieId") Integer movieId,
    		@RequestParam(required = true, value = "seatNum", defaultValue="1") Integer seatNum,
    		@RequestParam(required = true, value = "showTime", defaultValue="") String showTime,
    		@RequestParam(required = true, value = "seat", defaultValue="") String seat) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			if (userInfo == null) {
		        map.put("msg", "用户未登录");
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
			Date time;
			try {
				time = DateUtil.parse(showTime);
			} catch (Exception e) {
				map.put("msg", showTime + "时间格式不正确");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			Order order = new Order();
			order.setUsername(username);
			order.setCinemaId(cinemaId);
			order.setMovieId(movieId);
			order.setMakeTime(DateUtil.getCurrrentDate());
			order.setShowTime(time);
			order.setNum(seatNum);
			order.setSeat(seat);
			order.setStatue(2);

			int res = orderService.insertOrder(order);
			if (res > 0) {
		        map.put("msg", "");
		        map.put("status", "1");
			} else {
		        map.put("msg", "添加订单失败");
		        map.put("status", "0");  
			}
	        map.put("data", "");
			return map;
		} catch (Exception e) {
			logger.error("添加订单异常", e);
			map.put("msg", "添加订单异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
    @RequestMapping(value = "/{order_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "order_id") @PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			if (userInfo == null) {
		        map.put("msg", "用户未登录");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			int res = orderService.deleteOrder(order_id);
			if (res > 0) {
		        map.put("msg", "");
		        map.put("status", "1");
			} else {
		        map.put("msg", "删除订单失败");
		        map.put("status", "0");  
			}
	        map.put("data", "");  
			return map;
		} catch (Exception e) {
			logger.error("获取用户订单列表异常", e);
			map.put("msg", "获取用户订单列表异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
    @RequestMapping(value = "pay/{order_id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> payOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "order_id") @PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		HttpSession session = request.getSession();
			User userInfo = (User) session.getAttribute(ConstantUtils.USER_INFO);
			if (userInfo == null) {
		        map.put("msg", "用户未登录");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			Order order = orderService.getOrdersById(order_id);
			if (order != null) {
				// 提交订单之后，15分钟之内必须付款，否则视为订单失效
				if (DateUtil.getOffsetFromToday(order.getMakeTime(), 1000) > -900) {
			        orderService.payOrder(order_id);
					map.put("msg", "");
			        map.put("status", "1");
				} else {
					orderService.overPayTimeOrder(order_id);
			        map.put("msg", "超过15分钟之内没有付款");
			        map.put("status", "0");
				}
			} else {
		        map.put("msg", "订单付款失败，不存在该订单");
		        map.put("status", "0");  
			}
			map.put("data", "");  
			return map;
		} catch (Exception e) {
			logger.error("订单付款异常", e);
			map.put("msg", "订单付款异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
}
