package com.sysu.crawler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sysu.utils.DateUtil;
import com.sysu.utils.IpUtil;
import com.sysu.utils.JsonUtils;

public class HotMovieApi {
	static final String movie = "";

	public static void main(String[] args) throws JSONException,
			InterruptedException, SQLException {
		crawler();
	}

	public static void crawler() {
		DBUtil.systemOutToFile();
		try {
			updateHotMovies();

			String str = IpUtil
					.get("http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000");
			Map<String, Object> map = JsonUtils.json2Map(str);
			JSONObject json = (JSONObject) map.get("data");
			JSONArray jsonArray = (JSONArray) json.get("movies");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				String id = jsonObject.getString("id");
				MovieApi.crawler(id);
				if (queryById("hot_movie", id)) {
					System.out
							.println(id
									+ " exist, update but not insert to hot_movie table");
					updateHotMovies(id);
				} else {
					insertHotMovies(jsonObject);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
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

	public static void insertHotMovies(JSONObject jsonObject)
			throws SQLException, JSONException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into hot_movie(id,name,img,cat,star,sc,vd,dir,statue,insertTime,maoyanjson) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, jsonObject.getString("id"));
		ptmt.setString(2, jsonObject.getString("nm"));
		ptmt.setString(3, jsonObject.getString("img"));
		ptmt.setString(4, jsonObject.getString("cat"));
		ptmt.setString(5, jsonObject.getString("star"));
		ptmt.setString(6, jsonObject.getString("sc"));
		if (jsonObject.has("vd")) {
			ptmt.setString(7, jsonObject.getString("vd"));
		} else {
			ptmt.setString(7, "");
		}
		ptmt.setString(8, jsonObject.getString("dir"));
		ptmt.setInt(9, 1);
		ptmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
		ptmt.setString(11, "");
		ptmt.execute();
	}

	public static void updateHotMovies() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update hot_movie set statue=? where statue=? and date(insertTime) < ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "0");
		ptmt.setString(2, "1");
		ptmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
		ptmt.execute();
	}

	public static void updateHotMovies(String id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update hot_movie set statue=?, insertTime=? where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "1");
		ptmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		ptmt.setString(3, id);
		ptmt.execute();
	}

}
