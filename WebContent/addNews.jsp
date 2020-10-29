<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
    <%@ page import="com.hnjd.news.dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.hnjd.news.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
TopicDao topicdao = new TopicDaoImpl();
List<Topic> topiclist = new ArrayList();
topiclist = topicdao.getAllTopics();
request.setAttribute("topiclist", topiclist);

%>
<body>
	<form action="addNewsServlet" method="post" >
		新闻类型：
		<select name="ntid" >
		<c:forEach items="${topiclist}" var="topics">
			
			<option value="${topics.tid }">${topics.tname }</option>
			
			</c:forEach>
			</select>
		<br/>
		
		新闻标题：<input type="text" name="ntitle"><br/>
		新闻作者：<input type="text" name="nauthor"><br/>
		图片地址：<input type="text" name="npicPath">
		新闻内容：<textarea name="ncontent" rows="10" cols="20"></textarea>
		新闻概括：<textarea name="nsummary" rows="10" cols="20"></textarea>
		<input type="submit">
	</form>
</body>
</html>