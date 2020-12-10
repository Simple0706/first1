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
 * Servlet implementation class DengLuServlet
 */
@WebServlet("/DengLuServlet")
public class DengLuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DengLuServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auser = request.getParameter("user").trim();
		
		String pas = request.getParameter("pas").trim();
		
		User user = new User(auser,pas);
		UserService userService = new UserService();
		User dengLu = userService.DengLu(user);
		
		if(dengLu!=null){
			
			request.getSession().setAttribute("user", dengLu);
			response.getWriter().print("成功");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			response.getWriter().print("失败");
		}
	}

}
