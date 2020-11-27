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
		//根据name获取前台数据
		String thispage=request.getParameter("thispage");
		//根据name获取前台数据
		String showpage=request.getParameter("showpage");
		//string强转int
		int thispage1=Integer.valueOf(thispage);
		int showpage1=Integer.valueOf(showpage);
		//创建分页对象
		page pa = new page();
		//创建主题dao的实现类
		TopicDao top = new TopicDaoImpl();
		List<Topic> allTopics = null;
		try {
			//查询全部主题
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
			//将获取到的值存入分页对象
			pa.setThispage(thispage1);
			pa.setShowpage(showpage1);
			//limit查询新闻
 			List<News> countlist = newsDao.countnews((thispage1-1)*showpage1,showpage1);
 			//将新闻集合存入分页对象
			pa.setPagelist(countlist);
			
			pa.setCountpagesize(pa.getCountpagesize());
			if(thispage1>pa.getCountpagesize()){
				thispage1=0;
				response.getWriter().append("超出最大页数重置为首页");
				pa.setThispage(thispage1);
			}
			
			//将分页对象存入请求对象
			request.setAttribute("page", pa);
			//将对象存入会话对象
			request.getSession().setAttribute("countlist", countlist);
			request.getSession().setAttribute("allTopics", allTopics);
			//转发
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
		//根据name获取前台数据
		String aa = request.getParameter("obj");
		//将前台数据转换为json对象
		JSONObject json =  JSONObject.fromObject(aa);
		String thispage = (String)json.get("thispage");
		String showpage =(String)json.get("showpage");
		//string强转int
		int thispage1=Integer.valueOf(thispage);
		int showpage1=Integer.valueOf(showpage);
		try {
			//limit查找新闻
			List<News> countlist = newsDao.countnews((thispage1-1)*showpage1,showpage1);
			
			
			
			//创建json集合
			JSONArray jsono =new  JSONArray();
			
			//循环遍历新闻对象
			for(News n : countlist)
			{
				JSONObject jo = new JSONObject();
				jo.put("nid", n.getNid());
				jo.put("ntitle", n.getNtitle());
				jo.put("nauthor", n.getNauthor());
				jo.put("ncreateDate",n.getNcreateDate().toString());
				jsono.add(jo);
			}
			//转发
			response.getWriter().append(jsono.toString());
			
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
