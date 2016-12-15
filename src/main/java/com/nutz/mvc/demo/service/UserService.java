package com.nutz.mvc.demo.service;




import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.nutz.mvc.demo.entity.User;

public interface UserService {
	
	//根据用户名查询用户
	public User selectUser(String userName);
	
	//插入用户
	public User insertUser(User user);
	
	//根据用户名查询用户数量，即判断用户是否已存在
	public int countUser(String userName);
	
	//根据参数名称修改用户信息
	void updateUser(Map<String, Object> params , int userID)throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
