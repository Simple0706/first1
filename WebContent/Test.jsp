<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js">
	</script>
	<script type="text/javascript">
		var json={
			name:"张三",
			age:18,
			sex:"男",
		}
		//stringify stringify stringify stringify parse parse parse parse
		var jsonobj =JSON.stringify(json)
		$.ajax(
				{
					url:"testServlet",
					type:"post",
					data:{obj:jsonobj},
					dataType:"json",
					success:function(data){
						//tomcat改编码
						//URIEncoding="UTF-8"
						alert(data.message)
						
					},
					error:function(){
						
					}
				})
			
				/* $.json({
					url:"",
					type:"",
					data:{},
					dataType:"",
					success:function(){},
					error:function(){}
				}) */
	</script>
</body>
</html>