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
 * Servlet implementation class DeleteNewsServlet
 */
@WebServlet("/deleteNewsServlet")
public class DeleteNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * ɾ��һ������
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		NewsDao newsDao = new NewsDaoImpl();
		try {
			newsDao.deleteNews(Integer.valueOf(nid));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * ɾ����������
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] nids = request.getParameterValues("nids");
		try {
			NewsDao newsDao = new NewsDaoImpl();
			for(String nid :nids) {
				newsDao.deleteNews(Integer.valueOf(nid));
			}
		} catch (NumberFormatException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
