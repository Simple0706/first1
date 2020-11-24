<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>新闻详细信息</title>
</head>
<body>

<table>
<tr>
	<td>新闻ID：${newsById.nid}</td>
	<td>新闻标题：${newsById.ntitle}</td>
	<td>新闻内容：${newsById.ncontent}</td>
	</tr>
	
	<c:forEach items="${comlist}" var="comlists">
	 <tr>
	 <td>评论序号<input disabled="disabled" type="text" value="${comlists.cid}"></td>
	
	<td>评论时间<input disabled="disabled" type="text" value="${comlists.cdate}"></td>
	
	 <td>评论ip<input disabled="disabled" type="text" value="${comlists.cip}"></td>
	<td>评论内容<input disabled="disabled" type="text" value="${comlists.ccontent}"></td>
	
	 <td>评论人<input disabled="disabled" type="text" value="${comlists.cauthor}"></td>
	
	 </tr>
		 </c:forEach> 
		 <table id="ajaxcomment"></table>
		 </table>
	 <table>
	 <form action="selectNewsServlet" method="post" id="form">
	 	
	<tr>
	<td><input type="hidden" name="cid" value="${newsById.nid}" id="aaaaa"></td>
	</tr>
	<tr><td><input type="text" name="author" value="${newsById.nauthor}"></td></tr>
	<tr><td><input type="text" name="ip" value="${pageContext.request.remoteAddr}"></td></tr>
	<tr><td><textarea rows="10" cols="30" name="text" id=""></textarea></td></tr>
	
	<tr>
	<td><input type="submit" value="提交评论" ></td>
	<td><input type="button" value="ajax提交评论" id="but"></td>
	</tr>
	
	</form>
	</table>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</body>
</html>
	<script type="text/javascript">
	$(function(){
		
		$("#but").click(function(){
			
			var comment = {
					"cid":$(":input[name='cid']").val(),
					"author":$(":input[name='author']").val(),
					"ip":$(":input[name='ip']").val(),
					"text":$(":input[name='text']").val(),	
			}
			var comment1 = JSON.stringify(comment);
			$.ajax({
				url:"AjaxAddComment",
				type:"post",
				data:{comment:comment1},
				typedata:"json",
				success:function(data){
					var data1=JSON.parse(data);
					
					

					var html =" <tr>"+
					
					"<td>"+
					"评论作者"+
					"<input disabled='disabled' type='text'  value='{{nauthor}}'>"+
					"</td>"+
					
					
					
					"<td>"+
					"评论ip"+
					"<input disabled='disabled' type='text' name='ip' value='{{ip}}'>"+
					"</td>"+
					
				
					
					"<td>"+
					"评论内容"+
					"<textarea disabled='disabled' rows='1' cols='30' name='text' >{{text}}</textarea>"+
					"</td>"+
					"</tr>"
								
					$("#ajaxcomment").append(
							html . replace(/{{nauthor}}/g,data1.author)
							. replace(/{{ip}}/g,data1.ip)
							. replace(/{{text}}/g,data1.text))
				},
			error:function(){
				
			}
				
			})
			
			
			/* alert($("#form").serialize()) */
		})
	})
	
</script>