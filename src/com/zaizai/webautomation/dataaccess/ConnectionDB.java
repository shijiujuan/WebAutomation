package com.zaizai.webautomation.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.zaizai.webautomation.utils.EorrLog;

public class ConnectionDB {
	
	/**
	 * 以后做扩展
	 * @param path
	 * @param key
	 * @return
	 */
	/**
	//未完待续
	public static String readMySql(String path, String key) {
		Connection conn = null;
		ResultSet rs = null;
		String sql;

//		String url = ReadUtils.readProperties(path, key); // readUtil方法返回的vale

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			Statement stat = conn.createStatement();
			sql = "select * from user_table";
			rs = stat.executeQuery(sql);
			rs.first();// 表的第一行数据
			// while(rs.next()){
			// System.out.println(rs.getString("username"));
			// }
			String username = rs.getString("username");
			return username;
		} catch (Exception e) {
			EorrLog.Log("数据库存报错。" + e.toString());
			return null;
		}
	}*/
}
