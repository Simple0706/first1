<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form>
		用户名<input type="text" name="user"><br><br>
		密&nbsp;&nbsp;&nbsp;&nbsp;码<input type="password" name = "pas"><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="登录">
		
	</form>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		
		
		$("form").on("submit",function(){
			var uname = $(":text[name='user']").val().trim()
			var upwd = $(":password[name='pas']").val().trim()
			
			
			if(uname==""|| upwd==""){
				alert("有为空数据")
				return false
			}
			
			$.ajax({
				url:"DengLuServlet",
				type:"post",
				data:$('form').serializeArray(),
				datatype:"text",
				success:function(data){
					alert(data)
					if(data=="成功"){
						location.href="index.jsp";
					}else{
						alert("用户名或密码错误")
					}
				},
			error:function(){	
			}	
			})

			return false
			
		})
	})
	</script>

</body>
</html>