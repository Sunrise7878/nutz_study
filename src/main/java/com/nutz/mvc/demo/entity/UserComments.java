package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("t_leaves_word")
public class UserComments implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//留言ID
	@Id
	@Column("lwId")
	private int lWordId;
	
	//留言内容
	@Column("lwcontent")
	private String lContent;
	
	//留言时间
	@Column("lwtime")
	private Date lTime;
	
	@Column("uid")
	private int uId;
	
	
	public UserComments(){}

	public UserComments(String lContent, Date lTime) {
		super();
		this.lContent = lContent;
		this.lTime = lTime;
	}

	public int getlWordId() {
		return lWordId;
	}

	public void setlWordId(int lWordId) {
		this.lWordId = lWordId;
	}

	public String getlContent() {
		return lContent;
	}

	public void setlContent(String lContent) {
		this.lContent = lContent;
	}

	public Date getlTime() {
		return lTime;
	}

	public void setlTime(Date lTime) {
		this.lTime = lTime;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}
	
}
