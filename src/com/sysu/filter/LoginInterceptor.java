package com.sysu.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sysu.utils.ConstantUtils;
import com.sysu.utils.JsonUtils;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute(ConstantUtils.USER_INFO);
        if (user == null) {
            response.setStatus(401);
            response.setCharacterEncoding("UTF-8");  
            response.setContentType("application/json; charset=utf-8");  
            PrintWriter out = null;  
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msg", "用户未登录");
	        map.put("data", "");  
	        map.put("status", "0");
            try {  
                out = response.getWriter();  
                out.append(JsonUtils.objToJson(map));  
            } catch (IOException e) {  
                e.printStackTrace();  
            } finally {  
                if (out != null) {  
                    out.close();  
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}
