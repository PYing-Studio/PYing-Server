package com.sysu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MovieController {
    @RequestMapping(value = "hotMovies", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getHotMovie(HttpServletRequest request,
    		@RequestParam(required = true, value = "offset") Integer offset,
    		@RequestParam(required = true, value = "limit") Integer limit ) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getMovieDetail(HttpServletRequest request,
    		@RequestParam(required = true, value = "电影的id") @PathVariable("id") String id) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }
}

