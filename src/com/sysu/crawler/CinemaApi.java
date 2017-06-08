package com.sysu.crawler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sysu.utils.DateUtil;
import com.sysu.utils.IpUtil;
import com.sysu.utils.JsonUtils;

public class CinemaApi {

	public static void main(String[] args) throws JSONException {
		crawlerCinema();
//		for (int i = 0; i < 10; i++) {
//			System.out.println(DateUtil.getRandom(30, 60));
//		}
	}

	// 获取电影院列表，运行一次就可以了
	public static void crawlerCinema() throws JSONException {
		String str = IpUtil.get("http://m.maoyan.com/cinemas.json");
		Map<String, Object> map = JsonUtils.json2Map(str);
		JSONObject json = (JSONObject) map.get("data");
		Iterator it = json.keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			JSONArray jsonArray = (JSONArray) json.get(key);
			for (int i = 0; i < jsonArray.length(); i++) {
				try {
					JSONObject jsonObject = (JSONObject) jsonArray.get(i);
					insertCinema(jsonObject, key);
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("end");
	}

	public static void insertCinema(JSONObject jsonObject, String area)
			throws SQLException, JSONException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into cinema(id,city,area,addr,name,maoyanjson) values(?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, jsonObject.getString("id"));
		ptmt.setString(2, "广州");
		ptmt.setString(3, area);
		ptmt.setString(4, jsonObject.getString("addr"));
		ptmt.setString(5, jsonObject.getString("nm"));
		ptmt.setString(6, "");
		ptmt.execute();
	}
}
