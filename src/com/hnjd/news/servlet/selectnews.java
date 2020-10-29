package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.News;
import com.hnjd.news.entity.page;
//http://localhost:8080/selectnews?thispage=2&showpage=10
//http://localhost:8080/first1/selectnews?thispage=1&showpage=10
/**
 * Servlet implementation class selectnews
 */
@WebServlet("/selectnews")
public class selectnews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectnews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsDao newsDao = new NewsDaoImpl();
		String thispage=request.getParameter("thispage");
		String showpage=request.getParameter("showpage");
		int thispage1=Integer.valueOf(thispage);
		int showpage1=Integer.valueOf(showpage);
		try {
			List<News> countlist = newsDao.countnews((thispage1-1)*showpage1,showpage1);
			page pa = new page();
			pa.setPagelist(countlist);
			pa.setThispage(thispage1);
			pa.setShowpage(showpage1);
			pa.setCountpagesize(pa.getCountpagesize());
			System.out.println(pa.getCountpagesize());
			System.out.println(pa.getShowpage());
			
			request.setAttribute("page", pa);
			request.setAttribute("countlist", countlist);
			
			request.getRequestDispatcher("/page.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
