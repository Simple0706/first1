package com.hnjd.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.entity.User;
import com.hnjd.news.service.UserService;

/**
 * Servlet implementation class ZhuCeServlet
 */
@WebServlet("/ZhuCeServlet")
public class ZhuCeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhuCeServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname").trim();
		String password = request.getParameter("upwd").trim();
		
		User user = new User(uname,password);
		
		UserService userservice = new UserService();
		
		boolean zhuCe = userservice.zhuCe(user);
		
		if(zhuCe){
			response.getWriter().print("成功");
			
		}else{
			response.getWriter().print("失败");
		}
	}

}
