package com.sysu.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 自定义访问对象工具类
 * 
 * 获取对象的IP地址等信息
 * 
 */
public class IpUtil {

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 * 
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
	 * 192.168.1.100
	 * 
	 * 用户真实IP为： 192.168.1.110
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static String getCityByIp(String ip) {
		String city = "";
		String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + ip;
		String json = get(url);
		Map<String, Object> map = JsonUtils.json2Map(json);
		city = (String) map.get("city");
		return city;
	}
	
	public static String get(String url) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
		Response response;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		if (!response.isSuccessful()) {
			return "";
		}
		String res = "";
		try {
			res = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

}