package com.nutz.mvc.demo.service;


import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.nutz.mvc.demo.entity.User;

@IocBean(args = {"refer:dao"})
public class UserServiceImpl implements UserService{
	
	@Inject
	private Dao dao;
	
	
	public UserServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	public User selectUser(int userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public User insertUser(User user) {
		//查询该账号是否存在,若存在则注册失败
		if(dao.query(User.class, Cnd.where("userName", "=" , user.getUserName())).size() == 0){
			return dao.insert(user);
		}
		return null;
	}
	
	

}
