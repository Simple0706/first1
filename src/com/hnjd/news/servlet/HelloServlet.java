package com.hnjd.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public HelloServlet() {
		System.out.println("servlet创建...");
	}
	
	//servlet初始化的时间  首次访问该Servlet进行初始化操作
	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化...");
	}
	
	
	//servlet服务的时间
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
	}
	
	
	//servlet销毁的时间 关闭tomcat服务器
	@Override
	public void destroy() {
		System.out.println("servlet销毁....");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet调用doget....");
	}
	
}
