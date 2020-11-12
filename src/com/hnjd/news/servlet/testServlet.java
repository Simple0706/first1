package com.hnjd.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.entity.TestJson;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a = request.getParameter("obj");
		JSONObject objjson =new JSONObject(); 
		objjson=JSONObject.fromObject(a);
		TestJson t=(TestJson)JSONObject.toBean(objjson, TestJson.class);
//		JSONObject objjson1 =new JSONObject(); 
		objjson.put("message", "成功1");
		
//		JSONObject objjson1=	
//		objjson.put(key, value)
//		objjson1.put("message", "成功");
		
		System.out.println(t);
		
//		String bb="{\"message\":\"成功\"}";
//		if(a!=null){
//			
			response.getWriter().append(objjson.toString());
//			
//	}
	}

}
