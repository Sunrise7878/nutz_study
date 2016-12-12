package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 设备信息
 * @author admin
 *
 */
@Table("t_deviceinfo")
public class Device implements Serializable{

	private static final long serialVersionUID = 1L;

	//设备id
	@Id
	@Column("did")
	private int dId;
	
	//设备名称
	@Column("deviceName")
	private String deviceName;
	
	//设备型号
	@Column("deviceType")
	private String deviceType;
	
	//IMEI码
	@Column("IMEI")
	private String imei;
	
	//车辆ID
	@Column("carid")
	private int carId;
	
	//用户ID
	@Column("uid")
	private int uId;
	
	@One(target = Car.class , field = "carId")
	private Car car;
	
	 
	@One(target = User.class , field = "uId")
	private User user;

	@Many(target = AlarmInfo.class , field = "dId")
	private List<AlarmInfo> alarmInfos;
	
	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public List<AlarmInfo> getAlarmInfos() {
		return alarmInfos;
	}

	public void setAlarmInfos(List<AlarmInfo> alarmInfos) {
		this.alarmInfos = alarmInfos;
	}
}
