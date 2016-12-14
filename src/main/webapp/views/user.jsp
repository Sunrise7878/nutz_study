<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<%=basePath%>jquery/jquery.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>用户名：</td>
			<td><%=request.getSession().getAttribute("userName") %></td>
		</tr>
		<tr>
			<td>生日：</td>
			<td><%=request.getSession().getAttribute("birthday") %></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><%=request.getSession().getAttribute("gender") %></td>
		</tr>
		<tr>
			<td>城市：</td>
			<td><%=request.getSession().getAttribute("city") %></td>
		</tr>
		<tr>
			<td>体重：</td>
			<td><%=request.getSession().getAttribute("weight") %></td>
		</tr>
		<tr>
			<td>身高：</td>
			<td><%=request.getSession().getAttribute("height") %></td>
		</tr>
	</table>
	<a href="<%=basePath%>logout"><button  onclick="">退出登录</button></a>
</body>
</html>