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
	<!-- session:在某个浏览器运行期间一直生效 -->
	<c:set var="username" value="张三" scope="session"></c:set>
	<c:set var="salary" value="${2000 * 2}"></c:set>
	<!-- el表达式： -->
	${username}的薪资是${salary}
	
</body>
</html>