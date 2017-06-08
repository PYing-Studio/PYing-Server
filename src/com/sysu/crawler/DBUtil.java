package com.sysu.crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/pyin?autoReconnect=true";
	private static final String UNAME = "root";
	private static final String PWD = "mysql";

	private static Connection conn = null;

	public static void systemOutToFile() {
//		String fileName = "/yjdata/www/tomcat/webapps/api/crawler.txt";
		String fileName = "D:\\Workspaces\\MyEclipse Professional\\.metadata\\.me_tcat7\\webapps\\api\\crawler.txt";
		System.out.println(fileName);
		File logf = new File(fileName);
		try {
			logf.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(logf, true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		PrintStream printStream = new PrintStream(fileOutputStream);
		System.setOut(printStream);
		// System.setErr(printStream);
	}

	static {
		try {
			// 1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库的连接
			conn = DriverManager.getConnection(URL, UNAME, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}
