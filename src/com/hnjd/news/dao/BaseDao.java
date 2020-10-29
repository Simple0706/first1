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
		//1.�������ݿ�
		Connection conn = DatabaseUtil.getConnection();
		//2.�����ݿⷢ��sql���
		PreparedStatement pst = conn.prepareStatement(sql);
		//3.�����ݿⷢ�͸��Ӳ���
		for(int i = 0 ; i < params.length ; i++) {
			pst.setObject(i + 1, params[i]);
		}
		//4.ִ�в���
		int result = pst.executeUpdate();
		//5.�ر����ݿ�
		DatabaseUtil.closeAll(conn, pst, null);
		return result;
	}
	
	/**
	 * ��ѯ����
	 * @throws SQLException 
	 */
	public ResultSet excuteQuery(String sql,Object... params) throws SQLException {
		//1.��ȡ���ݿ�����
		Connection conn = DatabaseUtil.getConnection();
		//2.�����ݿⷢ��sql���"select * from news_users where uname=? and upwd=?"
		PreparedStatement pst = conn.prepareStatement(sql);
		//3.�����ݿ⴫�ݸ��Ӳ���
		for(int i = 0 ; i < params.length ; i++) {
			pst.setObject(i + 1, params[i]);
		}
		//4.ִ�в�ѯ����
		ResultSet result = pst.executeQuery();
		return result;
	}
}
