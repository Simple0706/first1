<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<input type="text" name = "user" onblur=abc(this) id="aaa" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">

	function abc(obj){
		
		var val=$("#aaa").val();
		alert(val);
		$.ajax({
			"url" : "selectNewsServlet",
			"date":"",
			"datatype":"",
			
			
		})
}


</script>



</body>
</html>