package com.sysu.controller;


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

import com.sysu.pojo.HotMovie;
import com.sysu.pojo.Movies;
import com.sysu.service.HotMovieService;
import com.sysu.service.MoviesService;
import com.sysu.utils.BeansUtils;
import com.sysu.utils.JsonUtils;

@Controller
@RequestMapping(value="/movie")
public class MovieController {
	private static Logger logger = Logger.getLogger(UserController.class);
	String[] ignorekey = {"insertTime", "statue", "maoyanjson"};
	
	@Autowired
	private MoviesService moviesService;
	@Autowired
	private HotMovieService hotMovieService;
	
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getHotMovie(HttpServletRequest request,
    		@RequestParam(required = true, value = "offset") Integer offset,
    		@RequestParam(required = true, value = "limit") Integer limit ) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			List<HotMovie> listOrders = hotMovieService.getHotMovies(offset, limit);
	        map.put("msg", "");
	        map.put("data",JsonUtils.changeListToMap(listOrders, ignorekey));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("获取热门电影列表异常", e);
			map.put("msg", "获取热门电影列表异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchMovie(HttpServletRequest request,
    		@RequestParam(required = true, value = "keyWord") String keyWord) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    		if (keyWord == null || "".equals(keyWord)) {
    			map.put("msg", "关键词不能为空");
    	        map.put("data", "");  
    	        map.put("status", "0");  
    	        return map;
			}
			List<Movies> movies = moviesService.searchMovies(keyWord);
	        map.put("msg", "");
	        map.put("data",JsonUtils.changeListToMap(movies, ignorekey));  
	        map.put("status", "1");  
			return map;
		} catch (Exception e) {
			logger.error("搜索电影异常", e);
			map.put("msg", "搜索电影异常");
	        map.put("data", "");  
	        map.put("status", "0");  
	        return map;
		}
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMovieDetail(HttpServletRequest request,
    		@PathVariable("id") Integer id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
			Movies movies = moviesService.selectMoviesById(id);
			if (movies == null) {
				map.put("msg", "获取电影详情失败，不存在该电影");
		        map.put("data", "");
		        map.put("status", "0");  
			}
	        map.put("msg", "");
	        map.put("data", BeansUtils.transBean2Map(movies));  
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
}

