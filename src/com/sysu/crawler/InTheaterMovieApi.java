package com.sysu.crawler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.math.RandomUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sysu.utils.DateUtil;
import com.sysu.utils.IpUtil;
import com.sysu.utils.JsonUtils;

public class InTheaterMovieApi {

	public static void main(String[] args) throws JSONException {
		crawler();
	}

	// 获取每一个电影院的当天电影排场信息
	public static void crawler() {
		DBUtil.systemOutToFile();
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select id from cinema";
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				String cinema_id = rs.getString("id");
				System.out.println(cinema_id);
				Boolean flag = true;
				int times = 20;
				while (flag) {
					try {
						crawlerInTheater(cinema_id);
						flag = false;
					} catch (NullPointerException e) {
						System.out.println(cinema_id
								+ " get null str, must stop for a while");
						Thread.sleep(1000 * 60 * times);
						times += DateUtil.getRandom(30, 60);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void crawlerInTheater(String cinema_id) throws JSONException,
			SQLException, InterruptedException {
		String str = IpUtil
				.get("http://m.maoyan.com/showtime/wrap.json?cinemaid="
						+ cinema_id + "&movieid=");
		Map<String, Object> map = JsonUtils.json2Map(str);
		JSONObject json = (JSONObject) map.get("data");
		JSONArray jsonArray = (JSONArray) json.get("movies");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			String movie_id = jsonObject.getString("id");
			Boolean flag = true;
			int times = 20;
			while (flag) {
				try {
					crawlerInTheaterMovie(cinema_id, movie_id);
					flag = false;
				} catch (NullPointerException e) {
					System.out.println(cinema_id + " " + movie_id
							+ " get null str, must stop for a while");
					Thread.sleep(1000 * 60 * times);
					times += DateUtil.getRandom(30, 60);
				}
			}
		}
		System.out.println(cinema_id + " cinema end");
	}

	public static void crawlerInTheaterMovie(String cinema_id, String movie_id)
			throws JSONException, SQLException, InterruptedException {
		System.out.println(cinema_id + " cinema " + movie_id + " movie start");
		String str = IpUtil
				.get("http://m.maoyan.com/showtime/wrap.json?cinemaid="
						+ cinema_id + "&movieid=" + movie_id);
		Map<String, Object> map = JsonUtils.json2Map(str);
		JSONObject jsonObject = (JSONObject) map.get("data");
		
		Iterator<?> it = jsonObject.getJSONObject("DateShow").keys();
		while (it.hasNext()) {
			String key = (String) it.next();
			JSONArray jsonArray = (JSONArray) jsonObject.getJSONObject("DateShow").get(key);
			for (int i = 0; i < jsonArray.length(); i++) {
				try {
					JSONObject timeJson = (JSONObject) jsonArray.get(i);
					if (!queryById(timeJson.getString("showId"))) {
						insertInTheaterMovie(timeJson, cinema_id, movie_id,
								jsonObject.getJSONObject("cinemaDetailModel").getString("nm"),
								jsonObject.getJSONObject("currentMovie").getString("nm"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		Thread.sleep(1000 * 30);
	}

	public static void insertInTheaterMovie(JSONObject jsonObject,
			String cinema_id, String movie_id,
			String cinema_name, String movie_name) throws SQLException,
			JSONException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into intheater_movie(id,cinema_id,movie_id,cinema_name,movie_name,num,leave_num,seat,show_time,maoyanjson) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, jsonObject.getInt("showId"));
		ptmt.setString(2, cinema_id);
		ptmt.setString(3, movie_id);
		ptmt.setString(4, cinema_name);
		ptmt.setString(5, movie_name);
		ptmt.setInt(6, 50);
		ptmt.setInt(7, 50);
		ptmt.setString(8, "");
		String time = jsonObject.getString("showDate") + " " + jsonObject.getString("tm");
		ptmt.setTimestamp(9, new Timestamp(DateUtil.strigToDate(time, "yyyy-MM-dd HH:mm").getTime()));
		ptmt.setString(10, jsonObject.toString());
		ptmt.execute();
	}
	
	public static void insertShowMovie(JSONObject jsonObject,
			String cinema_id, String movie_id) throws SQLException,
			JSONException {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into intheater_movie(cinema_id,movie_id,cinema_name,movie_name,statue,insertTime,maoyanjson) values(?,?,?,?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, cinema_id);
		ptmt.setString(2, movie_id);
		ptmt.setString(3,
				jsonObject.getJSONObject("cinemaDetailModel").getString("nm"));
		ptmt.setString(4,
				jsonObject.getJSONObject("currentMovie").getString("nm"));
		ptmt.setInt(5, 1);
		ptmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
		ptmt.setString(7, "");
		ptmt.execute();
	}

	public static void updateInTheaterMovie() throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update intheater_movie set statue=? where statue=? and Timestamp(insertTime) < ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "0");
		ptmt.setString(2, "1");
		ptmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
		ptmt.execute();
	}

	public static void updateInTheaterMovie(JSONObject jsonObject,
			String cinema_id, String movie_id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "update intheater_movie set statue=?, insertTime=?, maoyanjson=? where cinema_id=? and movie_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "1");
		ptmt.setDate(2, new Date(System.currentTimeMillis()));
		ptmt.setString(3, "");
		ptmt.setString(4, cinema_id);
		ptmt.setString(5, movie_id);
		ptmt.execute();
	}
	
	public static Boolean queryById(String cinema_id, String movie_id)
			throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from intheater_movie where cinema_id=? and movie_id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, cinema_id);
		ptmt.setString(2, movie_id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}
	
	public static Boolean queryById(String id)
			throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from intheater_movie where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}
	
}
