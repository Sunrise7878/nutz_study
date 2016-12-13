package com.nutz.mvc.demo.test;

import java.util.Scanner;

import org.junit.Test;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.nutz.mvc.demo.modules.UserModule;

public class TestUserModule extends TestBase{
	
	private UserModule userMoudle;
	
	private Scanner scanner;
	
	private static final Log log = Logs.getLog(TestUserModule.class);
	
	@Override
	protected void _bofore() throws Exception {
		userMoudle = ioc.get(UserModule.class);
		scanner = new Scanner(System.in);
	}
	
	//注册测试
	@Test
	public void register() throws Exception{
		System.out.print("请输入账号:");
		String userName = scanner.nextLine();
		System.out.print("请输入密码:");
		String passwd = scanner.nextLine();
		String result = userMoudle.register(userName, passwd, null, null);
		System.out.println("");
		log.debug("访问结果: " + result);
	}
	
	@Override
	protected void _after() throws Exception {}
}
