package com.nutz.mvc.demo.utils;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Result implements Serializable{
	
	/**
	 * 表示请求的处理状态
	 * <p> 值为"success":请求处理成功
	 * <p> 值为"error":请求失败
	 * <p> 值为"exception":请求过程中发生异常
	 */
	private String status;
	
	//请求结果的描述
	private String message;
	
	//请求的具体数据
	private Object data;

	public String getStatus() {
		return status;
	}
	
	public Result(){}

	public Result(String status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	//请求成功的方法
	public static String doSuccess(Object object){
		Result result = new Result();
		result.setStatus("success");
		result.setMessage("请求处理成功");
		result.setData(object);
		return JSON.toJSONString(result);
	}
	
	//请求失败的方法
	public static String doError(String message){
		Result result = new Result();
		result.setStatus("error");
		result.setMessage(message);
		return JSON.toJSONString(result);
	}
	
	//请求异常的方法
	public static String doException(String message){
		Result result = new Result();
		result.setStatus("exception");
		result.setMessage(message);
		return JSON.toJSONString(result);
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
