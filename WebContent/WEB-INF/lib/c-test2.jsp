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
	${username} ${salary }
	<!-- if(1==1){} -->
	<!-- 单个条件判断，不能做分支 -->
	<c:if test="${1 lt 1 }">
		c:if 表达式为true
	</c:if>
	
	<!-- 多个条件判断，可以做分支 -->
	<c:choose>
		<c:when test="${1 lt 1 }">
			1 &lt; 1
		</c:when>
		<c:when test="${1 gt 1 }">
			1 &gt; 1
		</c:when>
		<c:when test="${1 eq 1 }">
			1 = 1
		</c:when>
		<c:otherwise>
			其他情况
		</c:otherwise>
	</c:choose>
	
	<!-- 利用c:foreach实现：输出1-100之间所有的偶数-->
	
</body>
</html>