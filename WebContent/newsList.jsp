<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>新闻详细信息</title>
</head>
<body>
<form action="CommentAdd" method="post">
<table>
<tr>
	<td>新闻ID：${newsById.nid}</td>
	<td>新闻标题：${newsById.ntitle}</td>
	<td>新闻内容：${newsById.ncontent}</td>
	</tr>
	
	<c:forEach items="${comlist}" var="comlists">
 <tr>
 
	<td>${comlists.cid}</td>
	<td>${comlists.cnid}</td>
	<td>${comlists.ccontent}</td>
	<td>${comlists.cdate}</td>
	<td>${comlists.cip}</td>
	<td>${comlists.cauthor}</td>
	

	</tr> 
		 </c:forEach> 
	<tr>
	<td><input type="hidden" name="nid" value="${newsById.nid}"></td>
	<td><input type="hidden" name="author" value="${newsById.nauthor}"></td>
	<td><input type="text" name="text"></td>
	</tr>
	<tr>
	<td><input type="submit" ></td>
	</tr>
</table>
	</form>
</body>
</html>