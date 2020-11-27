package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;

/**
 * Servlet implementation class deleteNewsServlet1
 */
@WebServlet("/deleteNewsServlet1")
public class deleteNewsServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteNewsServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deleteNews = 0;
		//根据name获取前台的值
		String nid = request.getParameter("nid");
		
		 
		NewsDao newsDao = new NewsDaoImpl();
		try {
			//根据id删除新闻
			deleteNews = newsDao.deleteNews(Integer.valueOf(nid));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//根据影响行数响应前台
		if(deleteNews>=1){
		response.getWriter().append("true");
		}else{
			response.getWriter().append("false");
		}
	}

}
