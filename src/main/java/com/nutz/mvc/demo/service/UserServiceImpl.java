package com.nutz.mvc.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.nutz.mvc.demo.entity.User;

@IocBean()
public class UserServiceImpl implements UserService{
	
	@Inject
	private Dao dao;
	
	private List<User> users;
	
	public UserServiceImpl(){
		users = new ArrayList<User>();
		for(int i=1 ; i<6 ; i++){
			users.add(new User("user"+i, "123456", i+20));
		}
	}
	
	//查找用户
	public User selectUser(int userName) {
		for(User user : users){
			if(user.getUserName().equals("user"+userName)){
				return user;
			}
		}
		return null;
	}

	public boolean insertUser(User user) {
		
		return false;
	}

}
