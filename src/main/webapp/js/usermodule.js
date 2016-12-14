var basePath;
$(function() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
	basePath = window.location.protocol + '//' + window.location.host + '/'+ webName + '/';
});


//登录的函数
function login() {
	$.ajax({
		url : basePath + 'testjsonp',
		type : 'POST',
		dataType : 'json',
		data : {"userName" : $('#userName').val() , "passwd" : $('#passwd').val()},
		success : function(data) {
			if(data.status == 'success'){
				window.location =basePath + "views/user.jsp"
			}else{
				alert(data.message)
			}
		}
	});
}

//注册的函数
function register() {
	var result = checkTwoPasswd();
	if(result == null){
		$.ajax({
			url : basePath + 'register',
			dataType : 'json',
			type : 'POST',
			data : {"userName" : $('#reg_userName').val() , "passwd" : $('#reg_passwd').val() , "nickName" : $('#reg_nickName').val()},
			success : function(data) {
				if(data.status == 'success'){
					window.location =basePath + "views/user.jsp"
				}else{
					alert(data.message)
				}
			}
		});
	}else{
		alert(result);
	}
}

//注册时用户两次输入校验
function checkTwoPasswd() {
	var passwd = $.trim($('#reg_passwd').val());
	var rePasswd = $.trim($('#reg_re_passwd').val());
	if(passwd.length == 0 || rePasswd.length == 0){
		return "请输入密码";
	}else if(passwd == rePasswd){
		return null;
	}else {
		return "两次密码输入不一致";
	}
}