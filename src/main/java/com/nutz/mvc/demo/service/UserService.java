package com.nutz.mvc.demo.service;




import com.nutz.mvc.demo.entity.User;

public interface UserService {
	
	//根据用户名查询用户
	public User selectUser(String userName);
	
	//插入用户
	public User insertUser(User user);
	
	//根据用户名查询用户数量，即判断用户是否已存在
	public int countUser(String userName);
	
}
