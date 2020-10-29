package com.hnjd.news.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DatabaseUtil.getConnection();
		
		//3.与数据库交互
		String sql ="select * from news_users where uname=? and upwd=?";
		PreparedStatement pst = null;
		ResultSet res = null;
		try {
			pst = connection.prepareStatement(sql);
			pst.setObject(1, "admin");
			pst.setObject(2, "admin");
			res = pst.executeQuery();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			while(res.next()) {
			
				System.out.println("用户名"+res.getString("uname")
							+"\t"
							+"密码："+res.getString("upwd"));
			} 
		}catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//4.释放连接
		if(res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
