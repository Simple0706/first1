<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	
<form action="${pageContext.request.contextPath}/deleteNewsServlet" method="post">
		<table>
			<tr>
				<th><input type="submit" value="删除所选"></th>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${countlist}">
				<tr>
					<td><input type="checkbox" name="nids" value="${news.nid}"></td>
					<td>${news.ntid}</td>
					<td>
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}">${news.ntitle}</a>
					</td>
					
					<td>${news.nauthor}</td>
					<td>${news.ncreateDate}</td>
					<td>${news.nmodifyDate}</td>
					<td>	
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}&option=1">修改</a>
						<a href="${pageContext.request.contextPath}/deleteNewsServlet?nid=${news.nid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>

			
			<tr>
			<td>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${page.thispage-1}&showpage=10">上一页</a>
					<c:forEach begin="1" end="${page.countpagesize}" var="index">
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${index}&showpage=10">${index}</a>
					
					</c:forEach>
				<%-- 	<c:if test="${page.thispage<page.Countpagesize}">  --%>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${page.thispage+1}&showpage=10">下一页</a>
					<%-- </c:if>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=1&showpage=10">返回第一页</a> --%>
				</td>	
							
			
				
			</tr>
</table>
</body>
</html>