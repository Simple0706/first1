package com.hnjd.news.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener,HttpSessionAttributeListener{
	
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("添加属性---属性名："+arg0.getName()+"属性值"+arg0.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("删除属性---属性名："+arg0.getName()+"属性值"+arg0.getSession().getAttribute(arg0.getName()));
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("修改属性---属性名："+arg0.getName()+"属性值"+arg0.getSession().getAttribute(arg0.getName()));
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session创建");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Session销毁");
	}

}
