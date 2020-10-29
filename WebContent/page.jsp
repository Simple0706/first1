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
	<tr>
				
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				
			</tr>
	<c:forEach var="countlist" items="${countlist}" >
				
			
				
				<tr>
					
					<%-- <td>${countlist.ntid}</td> --%>
					<td>
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${countlist.nid}">${countlist.ntitle}</a>
					</td>
					
					<td>${countlist.nauthor}</td>
					<td>${countlist.ncreateDate}</td>
					<td>${countlist.nmodifyDate}</td>
					
				</tr>
			</c:forEach>
			
			<tr>
			<td>
					<c:forEach begin="1" end="${page.countpagesize}" var="index">
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${index}&showpage=10">${index}</a>
					</c:forEach>
					
				</td>	
							
			
				
			</tr>
</table>
</body>
</html>