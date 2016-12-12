package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 报警消息
 * @author admin
 *
 */
@Table("t_alarm")
public class AlarmInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//报警消息ID
	@Id
	@Column("alarmid")
	private int alarmId;
	
	//报警类型
	@Column("alarmType")
	private String alarmType;
	
	//报警时间
	@Column("alarmTime")
	private Date alarmTime;
	
	//报警位置
	@Column("alarmAddress")
	private String alarmAddress;
	
	@Column("did")
	private int dId;
	
	@One(field = "dId",target=Device.class)
	private Device device;
	
	public int getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmAddress() {
		return alarmAddress;
	}

	public void setAlarmAddress(String alarmAddress) {
		this.alarmAddress = alarmAddress;
	}


	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

}
