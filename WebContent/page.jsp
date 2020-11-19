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
	<c:forEach items="${allTopics}" var="top"> 
	<a href=" javascript:void()" class="a" id="newlist" data-tid="${top.tid}">
	${top.tname}
	</a>
	
	
	</c:forEach>
	
	
<form action="${pageContext.request.contextPath}/deleteNewsServlet" method="post" id="form">
		<table>
			<tr>
				<th><input type="submit" value="删除所选"></th>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${countlist}">
				<tr>
					<td><input type="checkbox" name="nids" value="${news.nid}"></td>
					<td>${news.ntid}</td>
					<td>
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}">${news.ntitle}</a>
					</td>
					
					<td>${news.nauthor}</td>
					<td>${news.ncreateDate}</td>
					<td>${news.nmodifyDate}</td>
					<td>	
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}&option=1">修改</a>
						<a href="${pageContext.request.contextPath}/deleteNewsServlet?nid=${news.nid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		
	</form>
</table>
			
			<tr>
			<td>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${page.thispage-1}&showpage=10">上一页</a>
					<c:forEach begin="1" end="${page.countpagesize}" var="index">
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${index}&showpage=10">${index}</a>
					
					</c:forEach>
				<%-- 	<c:if test="${page.thispage<page.Countpagesize}">  --%>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${page.thispage+1}&showpage=10">下一页</a>
					<%-- </c:if>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=1&showpage=10">返回第一页</a> --%>
				</td>	
							
			
				
			</tr>
</table>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
	

		$(".a").each(function(){
			$(this).click(function(){	
				var tnid=$(this).data("tid");
				
				$.ajax({
					url:"AjaxSelectNews",
					type:"Get",
					data:"tnid="+tnid,
					datatype:"json",
					success:function(data){
						var data1=JSON.parse(data)
						
						var html="<tr>"+
						"<td><input type='checkbox' name='nids' value='{{nid}}'></td>"+
						"<td>{{ntid}}</td>"+
						"<td>"+
							"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{nid}}'>{{ntitle}}</a>"+
						"</td>"+
						
						"<td>{{nauthor}}</td>"+
						"<td>{{ncreateDate}}</td>"+
						"<td>{{nmodifyDate}}</td>"+
						"<td>"+
							"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{nid}}'&option=1>修改</a>"+
							"<a href='${pageContext.request.contextPath}/deleteNewsServlet?nid={{nid}}'>删除</a>"
						"</td>"+
					"</tr>"
						
						$("#from").html("")
						
						for(var i=0;i<data1.length;i++){
							
							
							$("#from"). append(html
									. replace(/{{nid}}/g,data[i].nid)
									.replace(/{{ntit1e}}/g,data[i].ntit1e)
									.replace(/{{ncreateDate}}/g,data[i].ncreateDate)
									. replace(/{{nauthor}}/g, data[i] .nauthor)
									. replace(/{{nmodifyDate}}/g,data[i].nmodifyDate))
							
							
							
							
							
							
							
						//	alert(data1[i].nid)
							//alert(data1[i].ntitle)
						//	alert(data1[i].nauthor)
						//	alert(data1[i].ncreateDate)
						}
						
						
					},
					error:function(){
						alert("错误")
					}
					
				})
			
			})
		})
		
		
	})
	</script>



</body>
</html>