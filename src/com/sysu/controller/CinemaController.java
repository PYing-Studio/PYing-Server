package com.sysu.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CinemaController {
    @RequestMapping(value = "getCinemas", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getCinemas(HttpServletRequest request,
    		@RequestParam(required = true, value = "city_name") String city_name) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getMovieDetail(HttpServletRequest request,
    		@RequestParam(required = true, value = "cinemaid") Integer cinemaid,
    		@RequestParam(required = true, value = "movieid") Integer movieid) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }
}

