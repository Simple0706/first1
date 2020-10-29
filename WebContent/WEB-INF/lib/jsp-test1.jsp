<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP内置对象</title>
</head>
<body>
	<!-- request对象 -->
	<%=request.getContextPath() %><br>
	<%=request.getLocalAddr() %><br>
	
	<!-- response -->
	<%=response.getWriter().append("通过response输出内容到浏览器")%><br>
	
	<!-- out -->
	<%=out.append("通过out对象输出内容到浏览器")%><br>
	
	<!-- session 会话-->
	<%=session.getAttribute("username") %><br>
	
	<!-- application 应用 -->
	<%=application.getAttribute("sex") %><br>
	
	<!-- page 指当前页面本身，相当于java中的this对象-->
	<%=page%><br>
	
	<!-- pageContext 页面上下文 提供了jsp页面所有的对象-->
	<%=pageContext%>
	
	<!-- config对象  可以传递服务器的相关信息-->
	<%=config %>
	
	<!-- exception 异常  页面运行中出现了异常 就会产生这个对象-->
	<%=Exception.class%>
</body>
</html>