package com.nutz.mvc.demo.test;

import java.util.Scanner;

import org.junit.Test;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.mvc.demo.modules.UserModule;
import com.nutz.mvc.demo.utils.Result;

public class TestUserModule extends TestBase{
	
	private UserModule userMoudle;
	
	private Scanner scanner;
	
	private static final Log log = Logs.getLog(TestUserModule.class);
	
	@Override
	protected void _bofore() throws Exception {
		userMoudle = ioc.get(UserModule.class);
		scanner = new Scanner(System.in);
	}
	
	/*@Test
	public void TestLogin() throws Exception{
		System.out.print("输入账号:");
		String userName = scanner.nextLine();
		System.out.print("输入密码:");
		String passwd = scanner.nextLine();
		Result result = userMoudle.login(userName, passwd, null);
		log.debug("请求结果:" + result.getStatus());
		log.debug("请求消息:" + result.getMessage());
		log.debug("请求数据:" + result.getData());
	}*/
	
	@Test
	public void TestRegister() throws Exception{
		
	}
	
	@Override
	protected void _after() throws Exception {
	}
}
