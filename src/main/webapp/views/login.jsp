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
<title>登录测试</title>
<script src="<%=basePath%>jquery/jquery.min.js"></script>
<script src="<%=basePath%>js/usermodule.js" type="text/javascript"></script>
</head>
<body>
	<form action="#" method="post">
		<input type="text" name="userName" id="userName"/><br>
		<input type="text" name="passwd" id="passwd"/><br>
	</form>
	<button id="login" onclick="login()">登录</button>
	<a href="<%=basePath %>views/register.jsp"><button>注册</button></a>
	<div id="userShow"></div>
	
</body>
</html>