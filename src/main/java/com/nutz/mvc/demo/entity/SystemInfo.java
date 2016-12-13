package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("t_sys_message")
public class SystemInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//消息ID
	@Id
	@Column("messageId")
	private int messageId;
	
	//消息类型
	@Column("type")
	private String type;
	
	//消息内容
	@Column("content")
	private String content;
	
	//消息推送时间
	@Column("pushTime")
	private Date pushTime;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPushTime() {
		return pushTime;
	}

	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
}
