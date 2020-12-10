<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form >
		用户名<input type="text" name= "uname"><br>
		密码<input type="password" name= "upwd"><br>
		确认密码<input type="password" name= "upwd1"><br>
		<input type="submit"><br>
		
	</form>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		
		
		$("form").on("submit",function(){
			var uname = $(":text[name='uname']").val()
			var upwd = $(":password[name='upwd']").val()
			var upwd1 = $(":password[name='upwd1']").val()
			
			if(uname==""|| upwd=="" || upwd1==""){
				alert("有为空数据")
				return false
			}else if(!(upwd==upwd1)){
				alert("俩次密码不一致")
				return false
			}
			$.ajax({
				url:"ZhuCeServlet",
				type:"post",
				data:$('form').serializeArray(),
				datatype:"text",
				success:function(data){
					if(data=="成功"){
						alert("注册成功")
						location.href="DengLu.jsp";
					}else{
						alert("注册失败")
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