package com.nutz.mvc.demo.test.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.nutz.mvc.demo.service.UserService;
import com.nutz.mvc.demo.service.UserServiceImpl;
import com.nutz.mvc.demo.test.TestBase;

public class TestUserService extends TestBase{
	
	private UserService userService;
	
	@Override
	protected void _bofore() throws Exception {
		userService = ioc.get(UserServiceImpl.class);
	}
	
	@Test
	public void testUpdateUser() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Map<String, Object> params = new HashMap<>();
		params.put("userPwd", "12345610");
		params.put("userName", "test11111");
		userService.updateUser(params, 2);
	}
	
	@Override
	protected void _after() throws Exception {}
	
}
