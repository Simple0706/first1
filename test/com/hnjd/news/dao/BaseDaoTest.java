package com.hnjd.news.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.hnjd.news.util.DatabaseUtil;

public class BaseDaoTest {

	@Test
	public void testExcuteUpdate() throws SQLException {
		BaseDao baseDao = new BaseDao();
		String sql = "insert into news_users (uid,uname,upwd) values (?,?,?)";
		int result = baseDao.excuteUpdate(sql, 2,"test","123456");
		assertEquals(result, 1);
	}

	@Test
	public void testExcuteQuery() throws SQLException {
		BaseDao baseDao = new BaseDao();
		String sql = "select * from news_users where uname=? and upwd =?";
		ResultSet resultSet = baseDao.excuteQuery(sql, "admin","admin");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("uid")+"\t"+
								resultSet.getString("uname")+"\t"+
								resultSet.getString("upwd"));
		}
	}
}
