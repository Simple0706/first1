package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.hnjd.news.dao.*;

import com.hnjd.news.entity.*;

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
		TopicDao topicdao = new TopicDaoImpl();
		List<Topic> topiclist = new ArrayList();
		List<Comment> comlist = new ArrayList();
		CommentDao com = new CommentDaoImpl();
		try {
			comlist = com.getCommentsByNid(nid);
			request.setAttribute("comlist", comlist);
			
			newsById = newsDao.getNewsById(nid);
			request.setAttribute("newsById", newsById);
			 topiclist = topicdao.getAllTopics();
			request.setAttribute("topiclist", topiclist);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
		
		CommentDao com = new CommentDaoImpl();
		Comment comment = new Comment();
		comment.setCnid(Integer.valueOf(request.getParameter("cid")));
		comment.setCdate(new Date());
		comment.setCcontent(request.getParameter("text"));
		comment.setCauthor(request.getParameter("author"));
		comment.setCip(request.getParameter("ip"));
		request.getRequestDispatcher("newsList.jsp").forward(request, response);
		try {
			com.addComment(comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
