package com.nutz.mvc.demo.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassOperationsUtils {
	
	/**
	 * 	  <p><strong>功能：</strong>根据属性的名称设置属性的值（属性为Strng类型）, 属性名称必须和类里面的属性名一致，此处大小写敏感
	 *    @param name 需要设置的属性的名称
	 *    @param value 需要设置的属性的值
	 *    @param object 需要设置属性的对象
	 */
	public static void setStringValueByName(String name , Object value , Object object) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String firstLetter = name.substring(0, 1).toUpperCase();
		String setter = "set" + firstLetter + name.substring(1);
		Method method = object.getClass().getMethod(setter, String.class);
		method.invoke(object, value);
	}
}
