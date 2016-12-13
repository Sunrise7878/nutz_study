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
<script type="text/javascript">
	function login() {
		$.ajax({
			url : '<%=basePath%>testjsonp',
			type : 'POST',
			dataType : 'jsonp',
			jsonp:"callback",
			data : {"userName" : $('#userName').val() , "passwd" : $('#passwd').val()},
			jsonpCallback:"success_jsonp",
			success : function(data) {
				if(data.status == 'success'){
					window.location = "<%=basePath%>/views/user.jsp"
				}else{
					alert(data.message)
				}
			}
		});
	}
</script>
</head>
<body>
	<form action="#" method="post">
		<input type="text" name="userName" id="userName"/><br>
		<input type="text" name="passwd" id="passwd"/><br>
	</form>
	<button id="login" onclick="login()">登录</button>
	<div id="userShow"></div>
	
</body>
</html>