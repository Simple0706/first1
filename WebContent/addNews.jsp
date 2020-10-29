<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addNewsServlet" method="post" >
		新闻类型：
		<select name="ntid">
			<option value="1">国内</option>
			<option value="2">国际</option>
			<option value="3">军事</option>
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