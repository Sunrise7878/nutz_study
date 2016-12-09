package com.nutz.mvc.demo.service;


import com.nutz.mvc.demo.entity.User;


public interface UserService {
	
	//根据用户名查询用户
	public User selectUser(int userName);

}
