package com.nutz.mvc.demo.modules;

import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.mvc.demo.entity.User;
import com.nutz.mvc.demo.service.UserService;
import com.nutz.mvc.demo.utils.LoginFilter;
import com.nutz.mvc.demo.utils.MD5Encryption;
import com.nutz.mvc.demo.utils.Result;

@IocBean(args = {"refer:userService"})
public class UserModule {
	
	@Inject
	private UserService userService;
	
	public UserModule(UserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 * 	  <p><strong>功能：</strong>实现登录
	 *    <p> 1、判断用户输入参数是否为空，若为空则登录失败，若不为空则转2
	 *    <p> 2、调用service层selectUser方法，根据用户名查找用户，若查询结果为空则该用户不存在，若不为空则转3
	 *    <p> 3、将用户输入的密码利用MD5算法加密，并与查询出的用户密码进行比对，若匹配则登录成功，若不匹配则登录失败
	 *    <p> 4、捕获登陆过程中发生的异常并作相应处理
	 *    
	 *    @param userName 用户名
	 *    @param passwd 用户密码
	 *    
	 */
	@At("/testjsonp")
	@Ok("json")
	@Fail("json")
	public Result login(@Param("userName") String userName , @Param("passwd") String passwd , HttpSession session){
		try{
			Result result = userCheck(userName, passwd , null , false);
			if(result == null){
				User user = userService.selectUser(userName.trim());
				if(user.getUserPwd().equals(MD5Encryption.encryption(passwd.trim()))){
					putUserIntoSession(session, user);
					result = Result.doSuccess(user, "登录成功");
				}else{
					result = Result.doError("用户名与密码不匹配");
				}
			}
			return result;
		}catch (Exception e) {
			return Result.doException("服务器异常，请稍后重试");
		}
	}
	
	/**
	 * 
	 *    <p><strong>功能：</strong>将输入合法的user存储到数据库中，实现注册
	 *    <p> 1、判断用户输入的参数是否合法，若不合法则注册失败，若合法则转2
	 *    <p> 2、判断数据库中是否有该用户名的用户存在，若存在则注册失败，若不存在转3
	 *    <p> 3、将用户输入的参数封装成一个User对象，并调用service层方法，将该条记录插入到数据库中，注册成功
	 *    <p> 4、注册过程中，全程捕获异常，若发生异常，则注册失败
	 *    
	 */
	@At("/register")
	@Ok("json")
	@Fail("json")
	public Result register(@Param("userName") String userName , @Param("passwd") String passwd , @Param("nickName") String nickName , HttpSession session){
		try{
			Result result = userCheck(userName, passwd , nickName , true);
			if(result == null){
				User user = userService.insertUser(new User(userName.trim() , passwd.trim() , nickName.trim()));
				if(user != null && user.getuId() > 0){
					putUserIntoSession(session, user);
					result = Result.doSuccess(user, "注册成功");
				}else{
					result = Result.doError("注册失败，服务器异常");
				}
			}
			return result;
		}catch (Exception e) {
			return Result.doException("服务器异常，请稍后重试");
		}
	}
	
	@At("/test")
	@Ok("json")
	@Fail("json")
	@Filters(@By(type = LoginFilter.class))
	public Object testFilter(){
		return Result.doSuccess("登录成功", "登录成功");
	}
	
	/**
	 *    <p><strong>功能：</strong>退出登录
	 *    <p> 1、将session中存储的内容清空
	 *    <p> 2、重定向到程序初始界面
	 *    
	 */
	@At("/logout")
	@Ok(">>:/")
	public void logout(HttpSession session){
		session.invalidate();
	}
	
	/**
	 * 
	 *    <p><strong>功能：</strong>修改用户密码
	 *    <p> 1、判断用户输入的参数是否合法，若不合法则注册失败，若合法则转2
	 *    <p> 2、判断数据库中是否有该用户名的用户存在，若存在则注册失败，若不存在转3
	 *    <p> 3、将用户输入的参数封装成一个User对象，并调用service层方法，将该条记录插入到数据库中，注册成功
	 *    <p> 4、注册过程中，全程捕获异常，若发生异常，则注册失败
	 *    
	 */
	public Result changePasswd(@Param("userName") String userName , @Param("passwd") String passwd , HttpSession session) throws Exception{
		try{
			
		}catch (Exception e) {
			
		}
		return null;
	}
	
	/**
	 * 	  <p><strong>功能：</strong>检测用户输入数据的合法性（包含对空输入，密码长度以及用户存在性的判断）
	 *    @param isRegister 是否是注册
	 *    
	 */
	public Result userCheck(String userName , String passwd , String nickName , boolean isRegister){
		if(userName == null || passwd == null || Strings.isBlank(userName) || Strings.isBlank(passwd)){
			return Result.doError("用户名/密码不能为空");
		}
		if(passwd.trim().length()<6 || passwd.trim().length()>12){
			return Result.doError("输入的密码长度不合法");
		}
		if(isRegister) {
			if(nickName== null || Strings.isBlank(nickName)){
				return Result.doError("昵称不能为空");
			}
			if(userService.countUser(userName.trim()) > 0){
				return Result.doError("该用户已存在,请直接登录");
			}
		}else {
			if(userService.countUser(userName.trim()) == 0){
				return Result.doError("该用户不存在");
			}
		}
		return null;
	}
	
	/**
	 * 
	 *   <p><strong>功能：</strong>将登录或注册成功的用户信息存储在session中
	 *   @param session 会话
	 *   @param user 登录成功后的user对象
	 * 
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
