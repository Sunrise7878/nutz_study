package com.nutz.mvc.demo;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;


@Modules(scanPackage = true)
@IocBy(type = ComboIocProvider.class, args = {  
	    "*js", "conf/ioc/",   
	    "*anno", "com.nutz.mvc.demo"})
@SetupBy(value = MainSetup.class)
@IocBean
public class MainModule {
	
	@Inject
	private Dao dao;
	
	@At("/hello")
	@Ok("jsp:/views/hello")
	@Fail("jsp:/views/error")
	public String doHello(){
		System.out.println("Dao = " + dao);
		return "Hello Nutz!";
	}
	
	//重定向试用
	@At("/redirect")
	@Ok("redirect:/hello")
	@Fail("redirect:/hello")
	public void redirect(){
		
	}
	
	//Http返回码视图
	@At("/httpView")
	@Ok("http:403")
	@Fail("http:404")
	public void httpView(){
		
	}
	
	//空白视图
	@At("/voidView")
	@Ok("void")
	@Fail("void")
	public void voidView(){
		
	}
	
	
	
}
