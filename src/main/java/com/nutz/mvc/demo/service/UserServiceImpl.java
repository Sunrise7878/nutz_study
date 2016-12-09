package com.nutz.mvc.demo.service;


import java.util.List;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.nutz.mvc.demo.entity.User;

@IocBean(args = {"refer:dao"})
public class UserServiceImpl implements UserService{
	
	@Inject
	private Dao dao;
	
	private List<User> users;
	
	public UserServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	public User selectUser(int userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
