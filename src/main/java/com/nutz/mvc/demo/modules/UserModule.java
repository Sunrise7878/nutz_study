package com.nutz.mvc.demo.modules;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.nutz.mvc.demo.entity.User;
import com.nutz.mvc.demo.service.UserServiceImpl;
import com.nutz.mvc.demo.utils.Result;

@IocBean
public class UserModule {
	
	@Inject
	private UserServiceImpl userServiceImpl;
	
	/**
	 * @param userName 用户名
	 * @param passwd 用户密码
	 * 
	 * 根据userName参数调用service层查询出对应的user
	 * <p> 1、若返回值为null，则说明该用户不存在
	 * <p> 2、比对用户输入密码和查询出用户的密码，若匹配则登录成功，否则登录失败
	 */
	@At("/login")
	@Ok("json")
	@Fail("json")
	public Result login(@Param("userName") String userName , @Param("passwd") String passwd){
		System.out.println("123");
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

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	
}
