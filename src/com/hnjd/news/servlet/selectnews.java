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
import com.hnjd.news.dao.TopicDao;
import com.hnjd.news.dao.TopicDaoImpl;
import com.hnjd.news.entity.News;
import com.hnjd.news.entity.Topic;
import com.hnjd.news.entity.page;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
		page pa = new page();
		TopicDao top = new TopicDaoImpl();
		List<Topic> allTopics = null;
		try {
			allTopics = top.getAllTopics();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(thispage1<1 ){
				thispage1=1;
				response.getWriter().append("超出最小页数重置为首页");
			}
			
			pa.setThispage(thispage1);
			pa.setShowpage(showpage1);
			List<News> countlist = newsDao.countnews((thispage1-1)*showpage1,showpage1);
			pa.setPagelist(countlist);
			pa.setCountpagesize(pa.getCountpagesize());
			if(thispage1>pa.getCountpagesize()){
				thispage1=1;
				response.getWriter().append("超出最大页数重置为首页");
				pa.setThispage(thispage1);
			}
			
			
			request.setAttribute("page", pa);
			request.setAttribute("page", pa);
			request.getSession().setAttribute("countlist", countlist);
			request.getSession().setAttribute("allTopics", allTopics);
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
		NewsDao newsDao = new NewsDaoImpl();
		String aa = request.getParameter("obj");
		JSONObject json =  JSONObject.fromObject(aa);
		String thispage = (String)json.get("thispage");
		String showpage =(String)json.get("showpage");
		int thispage1=Integer.valueOf(thispage);
		int showpage1=Integer.valueOf(showpage);
		
		page pa = new page();
		TopicDao top = new TopicDaoImpl();
		List<Topic> allTopics = null;
		try {
			allTopics = top.getAllTopics();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			pa.setThispage(thispage1);
			pa.setShowpage(showpage1);
			List<News> countlist = newsDao.countnews((thispage1-1)*showpage1,showpage1);
			pa.setPagelist(countlist);
			pa.setCountpagesize(pa.getCountpagesize());
			
			
			JSONArray jsono =new  JSONArray();
			
			for(News n : countlist)
			{
				JSONObject jo = new JSONObject();
				jo.put("nid", n.getNid());
				jo.put("ntitle", n.getNtitle());
				jo.put("nauthor", n.getNauthor());
				jo.put("ncreateDate",n.getNcreateDate().toString());
				jsono.add(jo);
			}
			response.getWriter().append(jsono.toString());
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
