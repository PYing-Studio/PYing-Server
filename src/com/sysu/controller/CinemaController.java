package com.sysu.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sysu.pojo.Cinema;
import com.sysu.pojo.HotMovie;
import com.sysu.pojo.IntheaterMovie;
import com.sysu.pojo.Movies;
import com.sysu.service.CinemaService;
import com.sysu.service.HotMovieService;
import com.sysu.service.IntheaterMovieService;
import com.sysu.service.MoviesService;
import com.sysu.utils.BeansUtils;
import com.sysu.utils.JsonUtils;

@Controller
@RequestMapping(value="/cinema")
public class CinemaController {
	private static Logger logger = Logger.getLogger(UserController.class);
	String[] ignorekey = {"insertTime", "statue", "maoyanjson"};
	
	@Autowired
	private CinemaService cinemaService;
	@Autowired
	private IntheaterMovieService intheaterMovieService;
	
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getHotMovie(HttpServletRequest request,
    		@RequestParam(required = true, value = "city") String city,
    		@RequestParam(required = true, value = "area") String area) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		List<Cinema> listOrders = cinemaService.getCinemas(city, area);
	        map.put("msg", "");
	        map.put("data",JsonUtils.changeListToMap(listOrders, ignorekey));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("获取电影院列表异常", e);
			map.put("msg", "获取电影院列表异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }

    @RequestMapping(value = "/inTheater", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getIntheaterMovieDetail(HttpServletRequest request,
    		@RequestParam(required = true, value = "cinema_id") Integer cinema_id,
    		@RequestParam(required = true, value = "movie_id") Integer movie_id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
//    		String[] ignorekey = {"insertTime", "statue"};
    		if (cinema_id == null && movie_id == null) {
    			map.put("msg", "cinema_id 和 movie_id 不能同时为空");
    	        map.put("data", "");  
    	        map.put("status", "0");  
    			return map;
			}
			List<IntheaterMovie> moviesList = intheaterMovieService.getIntheaterMovie(cinema_id, movie_id);
	        map.put("msg", "");
	        map.put("data", JsonUtils.changeListToMap(moviesList, ignorekey));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("获取电影信息异常", e);
			map.put("msg", "获取电影信息异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
//	public  List<Map<String, Object>> mergeMapKeys(List<IntheaterMovie> moviesList) {
//		Map<String, Map<String, Object>> resMap = new HashMap<String, Map<String,Object>>>();
//		for (IntheaterMovie intheaterMovie : moviesList) {
//			String key = intheaterMovie.getCinemaId() + "_" + intheaterMovie.getMovieId();
//			if (resMap.containsKey(key)) {
//				
//			} else {
//				Map<String, Object> map = BeansUtils.transBean2Map(intheaterMovie);
//				resMap.put(key, value);
//			}
//		}
//		return resList;
//	}

}

