package com.nutz.mvc.demo.service;


import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;

import com.nutz.mvc.demo.entity.User;
import com.nutz.mvc.demo.utils.MD5Encryption;

@IocBean(args = {"refer:dao"})
public class UserServiceImpl implements UserService{
	
	@Inject
	private Dao dao;
	
	
	public UserServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}

	public User selectUser(String userName) {
		User user = dao.fetch(User.class , Cnd.where("userName" , "=" , userName.trim()));
		if(user == null || user.getuId() < 1){
			return null;
		}else{
			return user;
		}
	}

	public User insertUser(User user) {
		//查询该账号是否存在,若存在则注册失败
		if(dao.query(User.class, Cnd.where("userName", "=" , user.getUserName())).size() == 0){
			user.setUserPwd(MD5Encryption.encryption(user.getUserPwd()));
			return dao.insert(user);
		}
		return null;
	}

	public String checkUser(User user, boolean create) {
		if(user == null){
			return "空对象";
		}
		
		if(Strings.isBlank(user.getUserName()) || Strings.isBlank(user.getUserPwd())){
			return "用户名密码不能为空";
		}
		
		if(create && dao.count(User.class , Cnd.where("userName", "=", user.getUserName().trim()))!= 0){
			return "用户已存在";
		}
		
		return null;
	}
	
	

}
