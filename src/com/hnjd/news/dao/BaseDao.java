package com.hnjd.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hnjd.news.util.DatabaseUtil;

public class BaseDao {
	/**
	 * ��ɾ�Ĳ���
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int excuteUpdate(String sql,Object... params) throws SQLException {
		//1.获取连接对象
		Connection conn = DatabaseUtil.getConnection();
		//2.预编译sql
		PreparedStatement pst = conn.prepareStatement(sql);
		//3.占位符赋值
		for(int i = 0 ; i < params.length ; i++) {
			pst.setObject(i + 1, params[i]);
		}
		//4.ִ返回增删改操作影响行数
		int result = pst.executeUpdate();
		//5.释放资源
		DatabaseUtil.closeAll(conn, pst, null);
		return result;
	}
	
	/**
	 * ��ѯ����
	 * @throws SQLException 
	 */
	public ResultSet excuteQuery(String sql,Object... params) throws SQLException {
		//1.1.获取连接对象
		Connection conn = DatabaseUtil.getConnection();
		//2.预编译sql
		PreparedStatement pst = conn.prepareStatement(sql);
		//3.占位符赋值
		for(int i = 0 ; i < params.length ; i++) {
			pst.setObject(i + 1, params[i]);
		}
		
		//4.ִ返回查询结果集
		ResultSet result = pst.executeQuery();
		

		return result;
	}
}
