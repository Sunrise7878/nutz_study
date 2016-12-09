package com.nutz.mvc.demo.modules;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.mvc.demo.entity.User;
import com.nutz.mvc.demo.service.UserService;
import com.nutz.mvc.demo.utils.Result;

@IocBean
public class UserModule {
	
	@Inject
	private UserService userServiceImpl;
	
	/**
	 *    @param userName 用户名
	 *    @param passwd 用户密码
	 * 
	 *    根据userName参数调用service层查询出对应的user
	 *    <p> 1、若返回值为null，则说明该用户不存在
	 *    <p> 2、比对用户输入密码和查询出用户的密码，若匹配则登录成功，否则登录失败
	 */
	public Result login(@Param("userName") String userName , @Param("passwd") String passwd){
		
		return null;
	}
	
	
	/**
	 *   用户注册，调用service层将用户信息存储至数据库
	 *   <p> 若账号已存在，则注册失败
	 *   <p> 若账号不存在，则执行注册
	 */
	@At("/register")
	@Ok("json")
	@Fail("json")
	public Result register(@Param("::user.") User user){
		if(user.getPasswd() != null && user.getUserName() != null){
			userServiceImpl.insertUser(user);
			return Result.doSuccess(user);
		}else{
			return Result.doError("用户名和密码不能为空！");
		}
	}
	
	
	/*@At("/userlogin")
	@Ok("json")
	@Fail("json")
	public Result login(@Param("userName") String userName , @Param("passwd") String passwd){
		User user = userServiceImpl.selectUser(2);
		if(user != null){
			if(user.getPasswd().equals(passwd)){
				return Result.doSuccess(user);
			}else{
				return Result.doError("用户名密码不匹配");
			}
		}else{
			return Result.doError("该用户不存在");
		}
	}
	
	@At("/userReg")
	@Ok("json")
	@Fail("json")
	public Result resgiter(@Param("::user.") User user){
		if(userServiceImpl.insertUser(user)){
			return Result.doSuccess(user);
		}else{
			return Result.doError("注册失败");
		}
	}*/

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
}
