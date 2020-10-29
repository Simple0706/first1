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
${username}
	<c:forEach items="a,b,c,d,e,f,g" var="letter" begin="0" end="4" step="1" varStatus="status">
		第 ${status.index}个元素值：${letter}<br/>
	</c:forEach>
	
	<c:forTokens  var="letter1" items="a;b;c;d;e;f;g" delims=";">
		${letter1}
	</c:forTokens>
	
	<!-- 利用c:foreach实现：输出1-100之间所有的偶数-->
	<c:forEach begin="2"  end="100"  var="num" step="2">
		<c:if test="${num % 2 eq 0}">
			${num }
		</c:if>
	</c:forEach>
</body>
</html>