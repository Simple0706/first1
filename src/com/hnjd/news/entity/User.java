package com.hnjd.news.entity;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	public int getUid() {
		return uid;
	}
	public User() {
		super();
	}
	public User(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
