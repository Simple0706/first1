<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<>
<title>新闻详细信息</title>
</head>
<body>
<table>
<tr>
	<td>新闻ID：${newsById.nid}</td>
	<td>新闻标题：${newsById.ntitle}</td>
	<td>新闻内容：${newsById.ncontent}</td>
	</tr>
	
	
 <tr>
<%-- <c:forEach items="comlist" var="comlists">
	<td>用户id：${comlists.cid}</td>
	<td>用户名字：${comlists.cnid}</td>
	<td>用户地址：${comlists.ccontent}</td>
	<td>${comlists.cdate}</td>
	<td>${comlists.cip}</td>
	<td>${comlists.cauthor}</td>
	 </c:forEach> --%>
	</tr> 
	<tr>
	<td><input type="text" checked="你来说一说吧"></td>
	</tr>
	<tr>
	<td><input type="button" value="提交"></td>
	</tr>
</table>
	
</body>
</html>