package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.CommentDao;
import com.hnjd.news.dao.CommentDaoImpl;
import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.AjaxComment;
import com.hnjd.news.entity.Comment;
import com.hnjd.news.entity.News;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AjaxAddComment
 */
@WebServlet("/AjaxAddComment")
public class AjaxAddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAddComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jsoncomment = request.getParameter("comment");
		JSONObject json =new JSONObject();
		json=JSONObject.fromObject(jsoncomment);
		AjaxComment ajaxcomment = (AjaxComment)JSONObject.toBean(json,AjaxComment.class);
		CommentDao com = new CommentDaoImpl();
		Integer nid = Integer.valueOf(ajaxcomment.getCid());
		Comment comment = new Comment();
		comment.setCdate(new Date());
		comment.setCnid(nid);
		comment.setCcontent(ajaxcomment.getText());
		comment.setCauthor(ajaxcomment.getAuthor());
		comment.setCip(ajaxcomment.getIp());
		
		Date cdate = comment.getCdate();
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		String format = sdf.format(cdate);
		json.put("date", format);
		
		try {
			com.addComment(comment);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.getWriter().append(json.toString());
		try {
//			com.addComment(comment);
			
//			response.getWriter().append(comlist.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
