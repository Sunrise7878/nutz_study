package com.nutz.mvc.demo.test;

import java.util.Scanner;


import org.junit.Test;

import com.nutz.mvc.demo.modules.UserModule;
import com.nutz.mvc.demo.utils.Result;

public class TestUserModule extends TestBase{
	
	private UserModule userMoudle;
	
	@Override
	protected void _bofore() throws Exception {
		userMoudle = ioc.get(UserModule.class);
	}
	
	@Test
	public void TestLogin() throws Exception{
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入账号:");
		String userName = scanner.nextLine();
		System.out.print("输入密码:");
		String passwd = scanner.nextLine();
		Result result = userMoudle.login(userName, passwd, null);
		System.out.println("请求结果:" + result.getStatus());
		System.out.println("请求消息:" + result.getMessage());
		System.out.println("请求数据" + result.getData());
	}
	
	@Override
	protected void _after() throws Exception {
	}
}
