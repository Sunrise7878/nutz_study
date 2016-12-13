package com.nutz.mvc.demo.modules;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.mvc.demo.entity.User;
import com.nutz.mvc.demo.service.UserService;
import com.nutz.mvc.demo.utils.MD5Encryption;
import com.nutz.mvc.demo.utils.Result;

@IocBean(args = {"refer:userServiceImpl"})
public class UserModule {
	
	@Inject
	private UserService userService;
	
	public UserModule(UserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 *    @param userName 用户名
	 *    @param passwd 用户密码
	 *    
	 * 	    根据userName参数调用service层查询出对应的user
	 *    
	 *    <p> 1、判断用户输入参数是否为空，若为空则登录失败，若不为空则转2
	 *    <p> 2、调用service层selectUser方法，根据用户名查找用户，若查询结果为空则该用户不存在，若不为空则转3
	 *    <p> 3、将用户输入的密码利用MD5算法加密，并与查询出的用户密码进行比对，若匹配则登录成功，若不匹配则登录失败
	 *    <p> 4、捕获登陆过程中发生的异常并作相应处理
	 * 
	 */
	@At("/testjsonp")
	@Ok("raw")
	@Fail("raw")
	public String login_jsonp(@Param("userName") String userName , @Param("passwd") String passwd ,@Param("callback") String callback, HttpSession session){
		String result;
		try{
			if(Strings.isBlank(userName)  || Strings.isBlank(passwd)){
				result = Result.doError("用户名密码不能为空");
			}else if(userService.selectUser(userName.trim()) == null){
				result = Result.doError("该用户不存在");
			}else {
				User user = userService.selectUser(userName.trim());
				if(MD5Encryption.encryption(passwd.trim()).equals(user.getUserPwd())){
					putUserIntoSession(session, user);
					result = Result.doSuccess(user);
				}else{
					result = Result.doError("用户名与密码不匹配");
				}
			}
			String jsonp = callback + "(" + result + ")";
			return jsonp;
		}catch (Exception e) {
			return callback + "(" + Result.doException("服务器异常，请稍后重试") + ")";
		}
	}
	
	@At("/logout")
	@Ok(">>:/")
	public void logout(HttpSession session){
		session.invalidate();
	}
	
	/**
	 *   @param session 会话
	 *   @param user 登录成功后的user对象
	 * 
	 *   <p><strong>功能：</strong>将登录或注册成功的用户信息存储在session中
	 */
	public void putUserIntoSession(HttpSession session , User user){
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("passwd", user.getUserPwd());
		session.setAttribute("birthday", user.getBirthday());
		session.setAttribute("gender", user.getGender());
		session.setAttribute("city", user.getCity());
		session.setAttribute("weight", user.getWeight());
		session.setAttribute("height", user.getHeight());
	}
}
