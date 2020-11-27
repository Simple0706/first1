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
		//根据name获取前台的值
		String nid = request.getParameter("nid");
		NewsDao newsDao = new NewsDaoImpl();
		try {
			//根据id删除新闻
			newsDao.deleteNews(Integer.valueOf(nid));
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * ɾ����������
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//根据name获取前台的值
		String[] nids = request.getParameterValues("nids");
		try {
			NewsDao newsDao = new NewsDaoImpl();
			//循环遍历nids
			for(String nid :nids) {
				//根据id删除新闻
				newsDao.deleteNews(Integer.valueOf(nid));
			}
		} catch (NumberFormatException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		//转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
