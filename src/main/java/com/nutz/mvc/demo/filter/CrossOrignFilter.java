package com.nutz.mvc.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CrossOrignFilter implements Filter {
	
	private FilterConfig config = null;


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config=null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			// TODO Auto-generated method stub
		 	HttpServletResponse httpResponse = (HttpServletResponse) response;
	        // 表明它允许"http://xxx"发起跨域请求
	        httpResponse.setHeader("Access-Control-Allow-Origin",
	        		config.getInitParameter("AccessControlAllowOrigin"));
	        // 表明在xxx秒内，不需要再发送预检验请求，可以缓存该结果
	        httpResponse.setHeader("Access-Control-Allow-Methods",
	                config.getInitParameter("AccessControlAllowMethods"));
	        // 表明它允许xxx的外域请求
	        httpResponse.setHeader("Access-Control-Max-Age",
	               config.getInitParameter("AccessControlMaxAge"));
	        // 表明它允许跨域请求包含xxx头
	        httpResponse.setHeader("Access-Control-Allow-Headers",
	        		config.getInitParameter("AccessControlAllowHeaders"));
	        System.out.println("DOFILTER()");
	        chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		System.out.println("INIT()");
	}

}
