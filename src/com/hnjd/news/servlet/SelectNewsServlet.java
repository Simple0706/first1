package com.hnjd.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.News;

/**
 * Servlet implementation class SelectNewsServlet
 */
@WebServlet("/selectNewsServlet")
public class SelectNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nidStr = request.getParameter("nid");
		String option = request.getParameter("option");
		Integer nid = Integer.valueOf(nidStr);
		
		NewsDao newsDao = new NewsDaoImpl();
		News newsById = new News();
		try {
			newsById = newsDao.getNewsById(nid);
			request.setAttribute("newsById", newsById);
			
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			if("1".equals(option)){
				request.getRequestDispatcher("/editNews.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/newsList.jsp").forward(request, response);
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
