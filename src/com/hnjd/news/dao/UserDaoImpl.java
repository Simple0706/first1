package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hnjd.news.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int addUser(User user) throws SQLException {
		String sql="insert into news_users(uname,upwd)values(?,?)";
		int userif= excuteUpdate(sql, user.getUname(),user.getUpwd());
		return 0;
	}

	@Override
	public boolean isUserName(String name) throws SQLException {
		String sql="select * from news_users where uname=?";
		ResultSet res = excuteQuery(sql, name);
		if(res.next()){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public User DengLu(User user) {

		String sql1="select * from news_users where uname=concat(?) and upwd=concat(?) ";
		String sql="select * from news_users where uname=? and upwd=? ";
		try {
			ResultSet res = excuteQuery(sql, user.getUname(),user.getUpwd());
			if(res.next()){
				User user2 = new User(res.getString(2),res.getString(3));
				return user2;
			}else{
				return null;
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
		
	}

}
