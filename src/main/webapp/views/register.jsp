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
<title>注册测试</title>
<script src="<%=basePath%>jquery/jquery.min.js"></script>
<script src="<%=basePath%>js/usermodule.js" type="text/javascript"></script>
</head>
<body>
	<form action="#" method="post">
		<span>昵称：</span><input type="text" name="nickName" id="reg_nickName"/><br>
		<span>用户名：</span><input type="text" name="userName" id="reg_userName"/><br>
		<span>密码：</span><input type="text" name="passwd" id="reg_passwd"/><br>
		<span>确认密码：</span><input type="text" name="rePasswd" id="reg_re_passwd"/><br>
	</form>
	<button id="register" onclick="register()">注册</button>
</body>
</html>