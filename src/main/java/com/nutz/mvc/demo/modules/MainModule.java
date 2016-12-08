package com.nutz.mvc.demo.modules;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.nutz.mvc.demo.entity.User;

@Modules(scanPackage = true)
@IocBy(type = ComboIocProvider.class , args = {"*js" , "conf/ioc/" , "com.nutz.mvc.demo"})
public class MainModule {
	
	@At("/hello")
	@Ok("jsp:/views/hello")
	@Fail("jsp:/views/error")
	public String doHello(){
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
	
	//ioc试验
	public static void main(String[] args) throws ClassNotFoundException {
		Ioc ioc = new NutIoc(new ComboIocLoader("conf/ioc/iocbean.js"));
		User user = ioc.get(User.class,"xiaogan");
		System.out.println("name:" + user.getUserName() + "   passwd:" + user.getPasswd() + "   age:" + user.getAge());
	}
	
	
}
