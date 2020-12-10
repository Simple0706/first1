package com.hnjd.news.dao;

import java.sql.SQLException;

import com.hnjd.news.entity.User;

public interface UserDao {
	//添加用户
	public int addUser(User user)throws SQLException;
	
	//判断用户名是否存在
	public boolean isUserName(String name)throws SQLException;
	
	//登录
	public User DengLu(User user);
	
}
