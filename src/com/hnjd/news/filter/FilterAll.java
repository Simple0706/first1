package com.hnjd.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterAll implements Filter{
	FilterConfig arg0;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		String [] a = {"DengLu.jsp","UserZhuCe.jsp"};
		
		HttpServletRequest request =(HttpServletRequest )arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String requestURI = request.getRequestURI().toLowerCase();
		Object attribute = request.getSession().getAttribute("islogin");
		
		for(int x=0;x<a.length;x++){
			if(requestURI.contains(a[x].toLowerCase())){
				arg2.doFilter(arg0, arg1);
				return;
			}else{
				if(attribute==null){
					request.getRequestDispatcher("DengLu.jsp").forward(request, response);
				}else{
					
					arg2.doFilter(arg0, arg1);
				}
			}
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			this.arg0=arg0;
		
	}

}
