<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
<!--
a{
  color:black;
text-decoration: none;

}
a:VISITED {
	color:black;
}
a:HOVER {
	color:red;
}
-->
</style>
<body>
<form action="SelectLikeNews" style="text-align: center;" method="post">
查询内容<input type="text" name="like" placeholder="根据新闻标题和作者查询新闻">
<input type="submit" value="查询">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;<a href="addNews.jsp" style="color:red;">添加新闻</a>&nbsp;&nbsp;&nbsp;
<a href="AddTopic.jsp" style="color:red;">添加主题</a>
<br>
<br>
</form>
<table>
	

	<c:forEach items="${allTopics}" var="top"> 
	<a href=" javascript:void()" class="a" id="newlist" data-tid="${top.tid}">
	${top.tname}
	</a>
	</c:forEach>
	
<div>
<form action="${pageContext.request.contextPath}/deleteNewsServlet" method="post" id="form">
		<table>
			<tr>
				<th><input type="submit" value="删除所选"></th>
				<th>新闻主题序号</th>
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
						<button class="but1" type="button" data-nid="${news.nid}">删除</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>

			
			<tr>
			<td>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${page.thispage-1}&showpage=10" id="shang">上一页</a>
					<c:forEach begin="1" end="${page.countpagesize}" var="index">
					
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${index}&showpage=10" id="index">${index}</a>
					</c:forEach>
					
				<%-- 	<c:if test="${page.thispage<page.Countpagesize}">  --%>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=${page.thispage+1}&showpage=10" id="xia">下一页</a>
					<button type="button" id="ajaxxia">下一页 </button>
					<%-- </c:if>
					<a href="${pageContext.request.contentType}/first1/selectnews?thispage=1&showpage=10">返回第一页</a> --%>
					<select id="showpage" name="showpage">
					<option>10</option>
					<option>20</option>
					<option>30</option>
					</select>
				</td>	
					
			
				
			</tr>
</table>
</div>	
	<%-- <br>
	<br>
	<br>
	<br>
	<span style="font-size: 30px;color: red; align: center;">广告招商，有意向请联系管理员</span>
	 --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		<%-- --%>
		var aa=1;
		<%--默认分页  --%>
		$("#shang").show()
		
		<%--默认分页  --%>
		$("#xia").show()
		
		<%--自选分页隐藏  --%>
		$("#ajaxxia").hide()
		
			<%--按主题显示新闻。 --%>
		$(".a").each(function(){
			$(this).click(function(){	
				var tnid=$(this).data("tid");
				<%--按主题显示新闻AJAX --%>
				$.ajax({
					url:"AjaxSelectNews",
					type:"Get",
					data:"tnid="+tnid,
					datatype:"json",
					success:function(data){
						<%--将json对象抓换为js对象 --%>
						var data1=JSON.parse(data)
						
						<%--清空首页 --%>
						$("table").html(" ")
						
						<%--清空显示的新闻 --%>
						$("div").html(" ")
						
						<%--新闻显示模板 --%>
						var html="<tr>"+
						//"<td><input type='checkbox' name='nids' value='{{nid}}'></td>"+
						"<td>{{ntid}}</td>&nbsp;&nbsp;"+
						"<td>"+
							"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{ntid}}'> {{ntitle}} </a>&nbsp;&nbsp;"+
						"</td>"+
						
						"<td>{{nauthor}}&nbsp;&nbsp;</td>"+
						"<td>{{ncreateDate}}&nbsp;&nbsp;</td>"+
						/* "<td>{{nmodifyDate}}</td>"+ */
						"<td>"+
							"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{ntid}}&option=1'>修改</a>&nbsp;&nbsp;"+
							"<a href='${pageContext.request.contextPath}/deleteNewsServlet?nid={{ntid}}'>删除</a>&nbsp;&nbsp;"
						"</td>"+
					"</tr>"
						
						
						<%--循环追加新闻 --%>
						for(var i=0;i<data1.length;i++){
							
							
							$("div"). append(html
									. replace(/{{ntid}}/g,data1[i].nid)
									.replace(/{{ntitle}}/g,data1[i].ntitle)
									.replace(/{{ncreateDate}}/g,data1[i].ncreateDate)
									. replace(/{{nauthor}}/g, data1[i] .nauthor))
									//. replace(/{{nmodifyDate}}/g,data1[i].nmodifyDate))		
									//	alert(data1[i].nid)
										//alert(data1[i].ntitle)
									//	alert(data1[i].nauthor)
									//	alert(data1[i].ncreateDate)
						}
						
							
					},
					error:function(){
						<%--AJAX请求错误执行回调函数 --%>
						alert("错误")
					}
					
				})
			
			})
		})
		
		
	
	
	<%--分页自选显示新闻 --%>
	$("#showpage").change(function(){
		aa=1;
		var showpage=$(this).val();
		$("#shang").hide()
		
		$("#xia").hide()
		
		$("#ajaxxia").show()
	
		var obj = {
				"thispage":"1",
				"showpage":showpage
		}
		<%--将js对象转换为json对象 --%>
		var objjson=JSON.stringify(obj)
		$.ajax({
			url:"selectnews",
			data:{obj:objjson},
			type:"Post",
			datatype:"json",
			success:function(data){
				<%--将json对象转换为js对象 --%>
				var data1= JSON.parse(data);
				
				$("table").html(" ")
				$("div").html(" ")	
				var html="<tr>"+
						//"<td><input type='checkbox' name='nids' value='{{nid}}'></td>"+
						"<td>{{ntid}}&nbsp;&nbsp;</td>"+
						"<td>"+
							"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{ntid}}'> {{ntitle}} </a>&nbsp;&nbsp;"+
						"</td>"+
						
						"<td>{{nauthor}}&nbsp;&nbsp;</td>"+
						"<td>{{ncreateDate}}&nbsp;&nbsp;</td>"+
						/* "<td>{{nmodifyDate}}</td>"+ */
						"<td>"+
							"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{ntid}}&option=1'>修改</a>&nbsp;&nbsp;"+
							"<a href='${pageContext.request.contextPath}/deleteNewsServlet?nid={{ntid}}'>删除</a>&nbsp;&nbsp;"
						"</td>"+
					"</tr>"
						
				for(var i=0;i<data1.length;i++){

					$("div"). append(html
							. replace(/{{ntid}}/g,data1[i].nid)
							.replace(/{{ntitle}}/g,data1[i].ntitle)
							.replace(/{{ncreateDate}}/g,data1[i].ncreateDate)
							. replace(/{{nauthor}}/g, data1[i] .nauthor))
							//. replace(/{{nmodifyDate}}/g,data1[i].nmodifyDate))
								
							//	alert(data1[i].nid)
								//alert(data1[i].ntitle)
							//	alert(data1[i].nauthor)
							//	alert(data1[i].ncreateDate)
				}
			},
			
			error:function(){
				
			}
		})
		
		
	})
	
	/*ajax实现删除  */
	$(".but1").click(function(){
		var nid = $(this).data("nid");
		
		$.ajax({
			url:"deleteNewsServlet1",
			type:"Post",
			data:"nid="+nid,
			datatype:"text",
			success:function(data){
				if(data=="true"){
					var con =confirm("确认删除吗？")
					if(con==true){
					window.location.reload();
					}
				}
			},
			error:function(){
				<%--AJAX请求错误执行回调函数 --%>
			}
			
		})
		
	})
	
		<%--自选页数分页下一页 --%>
		$("#ajaxxia").click(function(){
			var showpage=$("#showpage").val();
			
			aa+=1;
			alert(aa)
			var obj = {
					"thispage":""+aa+"",
					"showpage":showpage
			}
			var objjson=JSON.stringify(obj)
			$.ajax({
				url:"selectnews",
				data:{obj:objjson},
				type:"Post",
				datatype:"json",
				success:function(data){
					var data1= JSON.parse(data);
					$("table").html(" ")
					$("div").html(" ")	
					var html="<tr>"+
							//"<td><input type='checkbox' name='nids' value='{{nid}}'></td>"+
							"<td>{{ntid}}</td>"+
							"<td>"+
								"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{ntid}}'> {{ntitle}} </a>&nbsp;&nbsp;"+
							"</td>"+
							
							"<td>{{nauthor}}&nbsp;&nbsp;</td>"+
							"<td>{{ncreateDate}}&nbsp;&nbsp;</td>"+
							/* "<td>{{nmodifyDate}}</td>"+ */
							"<td>"+
								"<a href='${pageContext.request.contextPath}/selectNewsServlet?nid={{ntid}}&option=1'>修改</a>&nbsp;&nbsp;"+
								"<a href='${pageContext.request.contextPath}/deleteNewsServlet?nid={{ntid}}'>删除</a>&nbsp;&nbsp;"
							"</td>"+
						"</tr>"
							
					for(var i=0;i<data1.length;i++){
						
						
						$("div"). append(html
								. replace(/{{ntid}}/g,data1[i].nid)
								.replace(/{{ntitle}}/g,data1[i].ntitle)
								.replace(/{{ncreateDate}}/g,data1[i].ncreateDate)
								. replace(/{{nauthor}}/g, data1[i] .nauthor))
								//. replace(/{{nmodifyDate}}/g,data1[i].nmodifyDate))
						
					//	alert(data1[i].nid)
						//alert(data1[i].ntitle)
					//	alert(data1[i].nauthor)
					//	alert(data1[i].ncreateDate)
					}
				},
				error:function(){
					
				}
			})
			
			
			
			
		})
	
	
	
  })	
	</script>



</body>
</html>