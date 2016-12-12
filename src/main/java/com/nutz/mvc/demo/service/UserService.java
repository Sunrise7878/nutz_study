package com.nutz.mvc.demo.service;



import com.nutz.mvc.demo.entity.User;

public interface UserService {
	
	//检查用户信息的合法性
	public String checkUser(User user , boolean create);
	
	//根据用户名查询用户
	public User selectUser(String userName);
	
	//插入用户
	public User insertUser(User user);

}
