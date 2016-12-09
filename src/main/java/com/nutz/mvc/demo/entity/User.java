package com.nutz.mvc.demo.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("user")
public class User {
	
	//用户ID
	@Id
	private int userID;
	
	//用户名称
	@Column
	private String userName;
	
	//用户密码
	@Column
	private String passwd;
	
	//用户年龄
	@Column
	private int age;
	
	public User(){}

	public User(int userID, String userName, String passwd, int age) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.passwd = passwd;
		this.age = age;
	}

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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", passwd=" + passwd + ", age=" + age + "]";
	}
	
	
	
}
