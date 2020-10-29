package com.hnjd.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hnjd.news.util.DatabaseUtil;

public class BaseDao {
	/**
	 * 增删改操作
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int excuteUpdate(String sql,Object... params) throws SQLException {
		//1.连接数据库
		Connection conn = DatabaseUtil.getConnection();
		//2.向数据库发送sql语句
		PreparedStatement pst = conn.prepareStatement(sql);
		//3.向数据库发送附加参数
		for(int i = 0 ; i < params.length ; i++) {
			pst.setObject(i + 1, params[i]);
		}
		//4.执行操作
		int result = pst.executeUpdate();
		//5.关闭数据库
		DatabaseUtil.closeAll(conn, pst, null);
		return result;
	}
	
	/**
	 * 查询操作
	 * @throws SQLException 
	 */
	public ResultSet excuteQuery(String sql,Object... params) throws SQLException {
		//1.获取数据库连接
		Connection conn = DatabaseUtil.getConnection();
		//2.向数据库发送sql语句"select * from news_users where uname=? and upwd=?"
		PreparedStatement pst = conn.prepareStatement(sql);
		//3.向数据库传递附加参数
		for(int i = 0 ; i < params.length ; i++) {
			pst.setObject(i + 1, params[i]);
		}
		//4.执行查询操作
		ResultSet result = pst.executeQuery();
		return result;
	}
}
