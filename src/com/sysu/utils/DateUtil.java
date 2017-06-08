package com.sysu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

	public static int getRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt(max) % (max - min + 1) + min;
	}

	/**
	 * emoji表情替换
	 * 
	 * @param source
	 *            原字符串
	 * @param slipStr
	 *            emoji表情替换成的字符串
	 * @return 过滤后的字符串
	 */
	public static String filterEmoji(String source, String slipStr) {
		if (StringUtils.isNotBlank(source)) {
			return source.replaceAll(
					"[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
		} else {
			return source;
		}
	}

	public static Date strigToDate(String str, String type) {
		// type: "yyyy-MM-dd HH:mm:ss"
		SimpleDateFormat sdf = new SimpleDateFormat(type);// 小写的mm表示的是分钟
		Date date = getCurrrentDate();
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 获取当前时间的标准秒
	public static long getCurrentDayBeginTimeStamp() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 001);
		return cal.getTimeInMillis();
	}

	// 获取当前时间
	public static Date getCurrrentDate() {
		Date date = new Date();
		return date;
	}

	// 获取当前时间的字符串形式
	public static String getCurrrentDateString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}

	public static String formatDate(Date date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date parse(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		return sdf.parse(strDate);
	}

	// 两个date之间相差多少天
	public static int getOffsetBetweenDay(Date begin, Date end) {
		return (int) ((end.getTime() - begin.getTime()) / 86400000);
	}

	// 两个date之间相差多少天
	public static int getOffsetBetweenDay(Date begin, Date end, int base) {
		return (int) ((end.getTime() - begin.getTime()) / base);
	}

	// 给定一个时间，判断与今天相差多少天
	public static int getOffsetFromToday(Date date) {
		return (int) ((System.currentTimeMillis() - date.getTime()) / 86400000);
	}

	// 给定一个时间，判断与今天相差多少天
	public static int getOffsetFromToday(Date date, int base) {
		return (int) ((System.currentTimeMillis() - date.getTime()) / base);
	}

	// 对Date进行日期单位的加减法
	public static Date dataIncrease(Date begin, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(begin);
		calendar.add(calendar.DATE, num);// 把日期往后增加一天.整数往后推,负数往前移动
		return calendar.getTime(); // 这个时间就是日期往后推一天的结果
	}
}
