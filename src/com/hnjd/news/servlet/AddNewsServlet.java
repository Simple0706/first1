package com.hnjd.news.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.News;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/addNewsServlet")//对外界提供的一个访问路径
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ntitle = request.getParameter("ntitle");
		ntitle = new String( ntitle.getBytes("ISO-8859-1") , "UTF-8");
		
		String username = request.getParameter("username");
		URLDecoder.decode(username, "utf-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ntid = request.getParameter("ntid");
		String ntitle = request.getParameter("ntitle");
		String nauthor = request.getParameter("nauthor");
		String npicPath = request.getParameter("npicPath");
		String ncontent = request.getParameter("ncontent");
		String nsummary = request.getParameter("nsummary");
		
		NewsDao newsDao = new NewsDaoImpl();
		
		News news = new News();
		news.setNtid(Integer.valueOf(ntid));
		news.setNtitle(ntitle);
		news.setNcreateDate(new Date());
		news.setNauthor(nauthor);
		news.setNpicPath(npicPath);
		news.setNcontent(ncontent);
		news.setNsummary(nsummary);
		news.setNmodifyDate(new Date());
		
		try {
			newsDao.addNews(news);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		response.getWriter().append("添加成功");
		
		
		//重定向
		//response.sendRedirect("http://localhost:8088/first/index.jsp");
		
		//转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
