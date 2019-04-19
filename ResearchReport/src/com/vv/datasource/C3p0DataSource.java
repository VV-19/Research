package com.vv.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3p0DataSource {
	private static final String connectionURL = "jdbc:mysql://localhost:3306/teacher_work"
			+ "?useUnicode=true&character=utf8"
			+ "&serverTimezone=GMT%2B8&useSSL=false";
	private static final String username = "root";
	private static final String password = "mysqlpassword";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final ComboPooledDataSource ds;
	static {
		ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass(driver);
			ds.setJdbcUrl(connectionURL);
			ds.setUser(username);
			ds.setPassword(password);
			ds.setInitialPoolSize(5);
			ds.setMaxPoolSize(20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		}catch(Exception e) {
			
		}
		return null;
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		closeResultSet(rs);
		closePreparedStatement(pstmt);
		closeConnection(conn);
	}
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void closePreparedStatement(PreparedStatement pstmt) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeConnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
