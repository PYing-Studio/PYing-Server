package com.sysu.crawler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sysu.utils.DateUtil;
import com.sysu.utils.IpUtil;
import com.sysu.utils.JsonUtils;

public class MovieApi {

	public static void crawler(String id) {
		try {
			if (queryById("movies", id)) {
				System.out.println(id
						+ " exist, can not insert to movies table");
			} else {
				Thread.sleep(1000 * 5);
				String str = IpUtil.get("http://m.maoyan.com/movie/" + id
						+ ".json");
				Map<String, Object> map = JsonUtils.json2Map(str);
				JSONObject json = (JSONObject) map.get("data");
				insertMovies(id, json);
			}
			System.out.println(id + " movie end");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(id + " movie error");
		}
	}

	public static Boolean queryById(String table, String id)
			throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from " + table + " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}

	public static void insertMovies(String id, JSONObject jsonObject)
			throws SQLException, JSONException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into movies(id,name,img,cat,star,sc,vd,dir,dra,maoyanjson) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		JSONObject jsObject = jsonObject.getJSONObject("MovieDetailModel");
		ptmt.setString(1, id);
		ptmt.setString(2, jsObject.getString("nm"));
		ptmt.setString(3, jsObject.getString("img"));
		ptmt.setString(4, jsObject.getString("cat"));
		ptmt.setString(5, jsObject.getString("star"));
		ptmt.setString(6, jsObject.getString("sc"));
		if (jsObject.has("vd")) {
			ptmt.setString(7, jsObject.getString("vd"));
		} else {
			ptmt.setString(7, "");
		}
		ptmt.setString(8, jsObject.getString("dir"));
		ptmt.setString(9, jsObject.getString("dra"));
//		DateUtil.filterEmoji(jsonObject.toString(), "[表情]")
		ptmt.setString(10, "");
		ptmt.execute();
	}
}
