package com.hnjd.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.News;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AjaxSelectNews
 */
@WebServlet("/AjaxSelectNews")
public class AjaxSelectNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxSelectNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("tnid");
		int ntid =Integer.valueOf(a);
				
		NewsDao news = new NewsDaoImpl();
		List<News> newsByTopicId = news.getNewsByTopicId(ntid);
		
		JSONArray json =new  JSONArray();
		
		for(News n : newsByTopicId)
		{
			JSONObject jo = new JSONObject();
			jo.put("nid", n.getNid());
			jo.put("ntitle", n.getNtitle());
			jo.put("nauthor", n.getNauthor());
			jo.put("ncreateDate",n.getNcreateDate().toString());
			json.add(jo);
		}
		response.getWriter().append(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
