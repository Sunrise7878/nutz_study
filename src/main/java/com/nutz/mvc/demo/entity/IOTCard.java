package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("t_iotcard")
public class IOTCard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//物联卡ID
	@Id
	@Column("cardid")
	private int cardId;
	
	//物联卡卡号
	@Column("cardNum")
	private String cardNum;
	
	//开启时间
	@Column("startTime")
	private Date startTime;
	
	//结束时间
	@Column("endTime")
	private Date endTime;
	
	//用户ID
	@Column("uid")
	private int uId;
	
	@One(target = User.class , field = "uId")
	private User user;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}
}
