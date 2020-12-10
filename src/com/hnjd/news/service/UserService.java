package com.hnjd.news.service;

import java.sql.SQLException;

import com.hnjd.news.dao.UserDao;
import com.hnjd.news.dao.UserDaoImpl;
import com.hnjd.news.entity.User;

public class UserService {
	UserDao userdao = new UserDaoImpl();
	//注册
	public boolean zhuCe(User user){
		try {
			boolean userName = userdao.isUserName(user.getUname());
			if(userName){
				userdao.addUser(user);
				return true;
			}else{
				return false;
			}
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}
	
	//登录
	public User DengLu(User user){
		
		  User dengLu = userdao.DengLu(user);
		
		return dengLu;
	}
	
	
}
