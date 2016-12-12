package com.nutz.mvc.demo.test;

import org.junit.After;
import org.junit.Before;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.IocLoader;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.mvc.annotation.IocBy;

import com.nutz.mvc.demo.MainModule;

public class TestBase {
	
	public Ioc ioc;
	
	@Before
	public void before() throws Exception{
		IocBy iocBy = MainModule.class.getAnnotation(IocBy.class);
		IocLoader loader = new ComboIocLoader(iocBy.args());
		ioc = new NutIoc(loader);
		_bofore();
	}
	
	@After
	public void after() throws Exception{
		_after();
		if(ioc != null){
			ioc.depose();
		}
	}
	
	protected void _bofore() throws Exception {}
	protected void _after() throws Exception{}

}
