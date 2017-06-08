package com.sysu.controller;

import java.util.HashMap;
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

import com.sysu.pojo.IntheaterMovie;
import com.sysu.pojo.MovieOrder;
import com.sysu.pojo.User;
import com.sysu.service.IntheaterMovieService;
import com.sysu.service.OrderService;
import com.sysu.service.UserService;
import com.sysu.utils.BeansUtils;
import com.sysu.utils.ConstantUtils;
import com.sysu.utils.DateUtil;
import com.sysu.utils.JsonUtils;


@Controller
@RequestMapping(value="/order")
public class OrderController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private IntheaterMovieService intheaterMovieService;
	
	//	http://localhost:8080/PYin_Server/order/?username=lin
	@RequestMapping(value =  {"", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allOrders(HttpServletRequest request) {
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
			List<MovieOrder> listOrders = orderService.getOrdersByUsername(username);
	        map.put("msg", "");
	        map.put("data", JsonUtils.changeListToMap(listOrders, null));  
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
    		@PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			MovieOrder order = orderService.getOrdersById(order_id);
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

	//	http://localhost:8080/PYin_Server/order/?username=strin&movieId=1&cinemaId=2&seatNum=3&showTime=2017-06-01 23:47:35&seat=q
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> makeOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "showTimeId") Integer showTimeId,
    		@RequestParam(required = true, value = "cinemaName") String cinemaName,
    		@RequestParam(required = true, value = "movieName") String movieName,
    		@RequestParam(required = true, value = "seatNum", defaultValue="1") Integer seatNum,
    		@RequestParam(required = true, value = "seat", defaultValue="") String seat) {
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
			IntheaterMovie intheaterMovie = intheaterMovieService.selectIntheaterMovieById(showTimeId);
			if (intheaterMovie.getLeaveNum() < seatNum) {
		        map.put("msg", "余票数不足" + seatNum + "张");
		        map.put("data", "");  
		        map.put("status", "0");  
		        return map;
			}
			
			MovieOrder order = new MovieOrder();
			order.setUsername(username);
			order.setShowTimeId(showTimeId);
			order.setCinemaId(intheaterMovie.getCinemaId());
			order.setMovieId(intheaterMovie.getMovieId());
			order.setMovieName(movieName);
			order.setCinemaName(cinemaName);
			order.setShowTime(intheaterMovie.getShowTime());
			order.setMakeTime(DateUtil.getCurrrentDate());
			order.setNum(seatNum);
			order.setSeat(seat);
			order.setStatus(2);
			order.setHasYueyin(0);

			int res = orderService.addOrder(order, intheaterMovie);
			if (res > 0) {
				HashMap<String, Object> tem = new HashMap<String, Object>();
				tem.put("order_id", order.getId());
		        map.put("msg", "");
		        map.put("data", tem);
		        map.put("status", "1");
			} else {
		        map.put("msg", "添加订单失败");
		        map.put("data", "");
		        map.put("status", "0");
			}
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
    		@PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		MovieOrder order = orderService.getOrdersById(order_id);
    		if (order == null) {
    	        map.put("data", "");  
		        map.put("msg", "订单不存在，无法删除");
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
			logger.error("删除订单异常", e);
			map.put("msg", "删除订单异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
    @RequestMapping(value = "/{order_id}/pay", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> payOrder(HttpServletRequest request,
    		@PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			MovieOrder order = orderService.getOrdersById(order_id);
			if (order != null) {
				if (order.getStatus() == 1) {
					map.put("msg", "订单已经完成了支付，无需重复支付");
					map.put("data", "");  
			        map.put("status", "0");
			        return map;
				}
				if (order.getStatus() == 0 || order.getStatus() == 3) {
					map.put("msg", "订单已经失效，无法进行支付");
					map.put("data", "");  
			        map.put("status", "0");
			        return map;
				}
				// 提交订单之后，15分钟之内必须付款，否则视为订单失效
				if (DateUtil.getOffsetFromToday(order.getMakeTime(), 1000) < 900) {
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
