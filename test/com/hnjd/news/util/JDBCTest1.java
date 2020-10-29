package com.hnjd.news.util;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class JDBCTest1 {

	@Test
	public void test() {
		/*int i = 1;
		int j = 1;
		assertEquals(i, j);*/
		Object obj = new Object();
		assertNull(obj);
	}

	@Test
	public void test1() {
		try {
			DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
