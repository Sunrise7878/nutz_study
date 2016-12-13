package com.nutz.mvc.demo.modules;

import javax.servlet.http.HttpSession;

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
	 *    根据userName参数调用service层查询出对应的user
	 *    <p> 1、检查用户输入的用户名和密码是否为空，若未空则登录失败，若不为空则转步骤2
	 *    <p> 2、调用service层selectUser函数，根据用户名查询该用户，若查询结果为空则登录失败，若不为空则转步骤3
	 *    <p> 3、利用MD5算法对用户输入的密码进行加密处理后与查询用户的密码比对，若匹配则登录成功，否则登录失败
	 *    <p> 4、对登录过程所发生的异常进行捕获
	 */
	@At("/login")
	@Ok("json")
	@Fail("json")
	public Result login(@Param("userName") String userName , @Param("passwd") String passwd , HttpSession session) throws Exception{
		try{
			if(Strings.isBlank(userName)  || Strings.isBlank(passwd)){
				return Result.doError("用户名密码不能为空");
			}else if(userService.selectUser(userName.trim()) == null){
				return Result.doError("该用户不存在");
			}else{
				User user = userService.selectUser(userName.trim());
				if(user.getUserPwd().equals(MD5Encryption.encryption(passwd))){
					return Result.doException("登录成功");
				return Result.doError("用户名和密码不能为空");
			}else if (userService.selectUser(userName.trim()) == null){
				return Result.doError("该账户不存在");
			}else {
				User user = userService.selectUser(userName.trim());
				if(MD5Encryption.encryption(passwd.trim()).equals(user.getUserPwd())){
					putUserIntoSession(session, user);
					return Result.doSuccess(user);
				}else{
					return Result.doError("用户名与密码不匹配");
					return Result.doError("用户名和密码不匹配");
				}
			}
		}catch (Exception e) {
			return Result.doException("服务器异常，请稍后重试");
		}
	}
	
	
	/**
	 *   用户注册，调用service层将用户信息存储至数据库
	 *   <p> 若账号已存在，则注册失败
	 *   <p> 若账号不存在，则执行注册
	 */
	@At("/register")
	@Ok("json")
	@Fail("json")
	public Result register(@Param("::user.") User user , HttpSession session) throws Exception{
		try{
			if(user == null ||Strings.isBlank(user.getUserName()) || Strings.isBlank(user.getUserPwd())){
				return Result.doError("用户名和密码不能为空");
			}else{
				User u = userService.insertUser(user);
				if(u == null){
					return Result.doError("该用户已存在，请直接登录");
				}else{
					putUserIntoSession(session, u);
					return Result.doSuccess("注册成功");
			if(user == null || Strings.isBlank(user.getUserName()) || Strings.isBlank(user.getUserPwd())){
				return Result.doError("用户名和密码不能为空");
			}else{
				User u = userService.insertUser(user);
				if(u == null){
					return Result.doError("该用户已存在，请直接登录");
				}else{
					return Result.doSuccess(u);
				}
			}
		}catch (Exception e) {
			return Result.doException("服务器异常，请稍后重试");
		}
	}
	
	/**
	 * @param session 会话
	 * @param user 登录成功后的user对象
	 * 
	 * <p>将登录或注册成功的用户信息存储在session中
	 */
	public void putUserIntoSession(HttpSession session , User user){
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("passwd", user.getUserPwd());
	}
}
