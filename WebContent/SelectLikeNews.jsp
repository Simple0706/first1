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

<c:forEach var="news" items="${newslist}">
<table>
				<tr>
					<td>${news.ntid}</td>&nbsp;&nbsp;
					<td>
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}">${news.ntitle}</a>&nbsp;&nbsp;
					</td>
					
					<td>${news.nauthor}</td>&nbsp;&nbsp;
					<td>${news.ncreateDate}</td>&nbsp;&nbsp;
					<td>${news.nmodifyDate}</td>&nbsp;&nbsp;
					<td>	
						&nbsp;<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}&option=1">修改</a>&nbsp;
						&nbsp;<a href="${pageContext.request.contextPath}/deleteNewsServlet?nid=${news.nid}">删除</a>&nbsp;
					</td>
				</tr>
				</table>
			</c:forEach>
</body>
</html>