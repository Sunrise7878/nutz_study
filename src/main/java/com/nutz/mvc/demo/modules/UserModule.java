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
	private UserService userServiceImpl;
	
	public UserModule(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	/**
	 *    @param userName 用户名
	 *    @param passwd 用户密码
	 * 
	 *    根据userName参数调用service层查询出对应的user
	 *    <p> 1、若返回值为null，则说明该用户不存在
	 *    <p> 2、比对用户输入密码和查询出用户的密码，若匹配则登录成功，否则登录失败
	 */
	@At("/login")
	@Ok("json")
	@Fail("json")
	public Result login(@Param("userName") String userName , @Param("passwd") String passwd , HttpSession session) throws Exception{
		try{
			if(Strings.isBlank(userName) || Strings.isBlank(passwd)){
				return Result.doError("用户名密码不能为空");
			}else{
				User user = userServiceImpl.selectUser(userName.trim());
				if(user == null){
					return Result.doError("该用户不存在");
				}else{
					if(MD5Encryption.encryption(passwd.trim()).equals(user.getUserPwd())){
						//putUserIntoSession(session, user);
						return Result.doSuccess(user);
					}else{
						return Result.doError("用户名密码不匹配");
					}
				}
			}
		}catch (Exception e) {
			return Result.doException("服务器异常");
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
			if(user.getUserPwd() != null && user.getUserName() != null){
				User u = userServiceImpl.insertUser(user);
				if(u != null && u.getuId() >0 && u.getUserName().equals(user.getUserName())){
					return Result.doSuccess(u);
				}
				return Result.doError("用户已存在或服务器异常");
			}else{
				return Result.doError("用户名和密码不能为空！");
			}
		}catch (Exception e) {
			return Result.doException("服务器异常，请稍后重试");
		}
		
	}
	
	/**
	 * 
	 * @param session
	 * @param user
	 * 
	 * 将登录或注册成功的用户信息存储在session中
	 * 
	 */
	public void putUserIntoSession(HttpSession session , User user){
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("passwd", user.getUserPwd());
	}
	
	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
}
