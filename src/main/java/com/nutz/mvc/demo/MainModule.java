package com.nutz.mvc.demo;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;

public class MainModule {
	
	@At("/hello")
	@Ok("jsp:/views/hello")
	@Fail("jsp:/views/error")
	public String doHello(){
		return "Hello Nutz!";
	}
}
