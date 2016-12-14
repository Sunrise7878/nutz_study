package com.nutz.mvc.demo.test;

import java.util.Scanner;

import org.junit.Test;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.alibaba.fastjson.JSON;
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
	
	//注册测试
	@Test
	public void register() throws Exception{
		System.out.print("请输入昵称:");
		String nickName = scanner.nextLine();
		System.out.print("请输入账号:");
		String userName = scanner.nextLine();
		System.out.print("请输入密码:");
		String passwd = scanner.nextLine();
		Result result = userMoudle.register(userName, passwd , nickName , null);
		System.out.println("");
		log.debug("访问结果: " + JSON.toJSONString(result));
	}
	
	@Override
	protected void _after() throws Exception {}
}
