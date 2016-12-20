package com.nutz.mvc.demo.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.json.JsonFormat;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.UTF8JsonView;

public class LoginFilter implements ActionFilter{

	@Override
	public View match(ActionContext actionContext) {
		// TODO Auto-generated method stub
		/*HttpServletRequest httpServletRequest = actionContext.getRequest();
		actionContext.getRequest().getSession();
		Map<String, String> map = new HashMap<String, String>();
	    Enumeration headerNames = httpServletRequest.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = httpServletRequest.getHeader(key);
	        map.put(key, value);
	        System.out.println(key + " : " + value);
	    }*/
		HttpSession session = actionContext.getRequest().getSession();
		
		if(session.getAttribute("userName") != null){
			System.out.println(session.getAttribute("userName"));
			return null;
		}else{
			return new UTF8JsonView(JsonFormat.compact()).setData(Result.doError("请先登录"));
		}
	}
	
	

}
