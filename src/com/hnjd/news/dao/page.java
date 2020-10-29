package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnjd.news.entity.News;

public class page {
	//当前页面
	private int thispage;
	
	//总数据记录
	private int countpage;
	
	
	//显示页面行数
	private int showpage;
	
	
	//总页面数
	private int countpagesize;
	
	
	//数据集合
	private List<News> pagelist;
	
	
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		this.thispage = thispage;
	}
	
	public int getCountpage() {
		int a=1;
		try {
			a= new NewsDaoImpl().getAllNews().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	public int getShowpage() {
		return 1;
	}
	public void setShowpage(int showpage) {
		this.showpage = showpage;
	}
	public int getCountpagesize() {
		return countpage%showpage==0? countpage/showpage:countpage/showpage+1;
	}
	public void setCountpagesize(int countpagesize) {
		this.countpagesize = countpagesize;
	}
	public List<News> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<News> pagelist) {
		this.pagelist = pagelist;
	}
	
	
	
	
}
