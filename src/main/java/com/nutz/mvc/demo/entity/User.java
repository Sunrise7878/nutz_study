package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;



/**
 * 用户信息
 * @author admin
 *
 */
@Table("t_user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//用户id
	@Id
	@Column("uid")
	private int uId;
	
    //用户账号
	@Column("userNum")
	private String userName;
	
	//用户密码
	@Column("userPwd")
	private String userPwd;
	
	//手机验证码
	@Column("checkCode")
	private int checkCode;		
	
	//用户昵称
	@Column("nickName")
	private String nickName;
	
	//用户性别
	@Column("gender")
	private String gender;
	
	//用户身高
	@Column("height")
	private int height;
	
	//用户体重
	@Column("weight")
	private Double weight;
	
	//用户生日
	@Column("birthday")
	private Date birthday;
	
	//城市
	@Column("city")
	private String city;
	
	@Many(target = UserComments.class , field = "uId")
	private List<UserComments> comments;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	public User() {
		super();
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public int getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(int checkCode) {
		this.checkCode = checkCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public List<UserComments> getComments() {
		return comments;
	}
	public void setComments(List<UserComments> comments) {
		this.comments = comments;
		
	}
	public User(int uId, String userName, String userPwd, int checkCode, String nickName, String gender, int height,
			Double weight, Date birthday, String city, List<UserComments> comments) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.checkCode = checkCode;
		this.nickName = nickName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.city = city;
		this.comments = comments;
	}
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
