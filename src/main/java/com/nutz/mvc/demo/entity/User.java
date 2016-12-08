package com.nutz.mvc.demo.entity;

public class User {
	
	//用户名称
	private String userName;
	
	//用户密码
	private String passwd;
	
	//用户年龄
	private int age;
	
	public User(){}

	public User(String userName, String passwd, int age) {
		super();
		this.userName = userName;
		this.passwd = passwd;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
