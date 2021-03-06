package com.nutz.mvc.demo.service;


import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.nutz.mvc.demo.entity.User;
import com.nutz.mvc.demo.utils.ClassOperationsUtils;
import com.nutz.mvc.demo.utils.MD5Encryption;


@IocBean(args = {"refer:dao"} , name = "userService")
public class UserServiceImpl implements UserService{
	
	@Inject
	private Dao dao;
	
	public UserServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}
	
	//根据用户名查询用户
	public User selectUser(String userName) {
		User user = dao.fetch(User.class , Cnd.where("userName" , "=" , userName.trim()));
		if(user == null || user.getuId() < 1){
			return null;
		}else{
			return user;
		}
	}
	
	//插入用户
	public User insertUser(User user) {
		user.setUserPwd(MD5Encryption.encryption(user.getUserPwd()));
		return dao.insert(user);
	}
	
	//根据用户名查询用户数量，即判断用户是否已存在
	public int countUser(String userName) {
		return dao.count(User.class, Cnd.where("userName", "=", userName.trim()));
	}

	//根据参数名称修改用户信息
	@Override
	public void updateUser(Map<String, Object> params , int userID) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User user = dao.fetch(User.class, Cnd.where("uId", "=", userID));
		Iterator<Entry<String, Object>> entries = params.entrySet().iterator();
		while (entries.hasNext()){
			Entry<String, Object> entry = entries.next();
			ClassOperationsUtils.setStringValueByName(entry.getKey(), entry.getValue(), user);
		}
		System.out.println(user.toString());
		dao.update(user);
	}
	
	
}
