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
		//根据name获取前台的值
		String jsoncomment = request.getParameter("comment");
		//创建一个json对象
		JSONObject json =new JSONObject();
		//将前台获取的值转换为json对象
		json=JSONObject.fromObject(jsoncomment);
		//根据json对象创建实体类，并转为为该对象接收数据
		AjaxComment ajaxcomment = (AjaxComment)JSONObject.toBean(json,AjaxComment.class);
		CommentDao com = new CommentDaoImpl();
		//将字符串强转为int类型。自动拆箱
		Integer nid = Integer.valueOf(ajaxcomment.getCid());
		Comment comment = new Comment();
		comment.setCdate(new Date());
		comment.setCnid(nid);
		comment.setCcontent(ajaxcomment.getText());
		comment.setCauthor(ajaxcomment.getAuthor());
		comment.setCip(ajaxcomment.getIp());
		
		Date cdate = comment.getCdate();
		//改变时间格式
		String strDateFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		String format = sdf.format(cdate);
		//为json对象添加键值
		json.put("date", format);
		
		try {
			//添加评论对象
			com.addComment(comment);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//响应给前台一个json数据
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
