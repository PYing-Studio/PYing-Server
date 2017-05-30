package com.sysu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/order")
public class OrderController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> allOrders(HttpServletRequest request,
    		@RequestParam(required = true, value = "用户名") String username) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }
	
	@RequestMapping(value = "/{Order_id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> detailOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "订单id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> makeOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "username") String username,
    		@RequestParam(required = true, value = "电影院的id") String cinemaid,
    		@RequestParam(required = true, value = "该电影院下的电影id") String movieid) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{Order_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> deleteOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "订单的id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "statue/{Order_id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> statueOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "订单的id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "pay/{Order_id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> payOrder(HttpServletRequest request,
    		@RequestParam(required = true, value = "订单的id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
