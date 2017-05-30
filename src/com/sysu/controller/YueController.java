package com.sysu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/yueyin")
public class YueController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> allYueyin(@RequestParam(required = true, value = "用户名") String username) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");
        map.put("status", "0");
        return map;  
    }
	
	@RequestMapping(value = "/{YueyinId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> detailYueyin(@RequestParam(required = true, value = "用户名")  @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> makeYueyin(@RequestParam(required = true, value = "电影院的id") String cinemaid,
    		@RequestParam(required = true, value = "该电影院下的电影id") String movieid) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{YueyinId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> deleteYueyin(@RequestParam(required = true, value = "订单的id") @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "enter/{YueyinId}/{username}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> enterYueyin(@RequestParam(required = true, value = "用户名") @PathVariable("username") String username,
    		@RequestParam(required = true, value = "订单的id") @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "enter/{YueyinId}/{username}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, String> leaveYueyin(@RequestParam(required = true, value = "用户名") @PathVariable("username") String username,
    		@RequestParam(required = true, value = "订单的id") @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
