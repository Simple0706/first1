package com.hnjd.news.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class ConfigTest {

	//获取配置文件测试
	@Test
	public void test() throws IOException {
		Properties pro = new Properties();
		pro.load(ConfigTest.class.getClassLoader().getResourceAsStream("db.properties"));
		String url = pro.getProperty("url");
		System.out.println(url);
	}

}
