package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 用车报告信息
 * @author admin
 *
 */
@Table("t_car_report")
public class ReportVehicleInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//报告ID
	@Id
	@Column("crid")
	private int reportId;
	
	//起始地点
	@Column("startPlace")
	private String startPlace;
	
	//结束地点
	@Column("endPlace")
	private String endPlace;
	
	//起始时间
	@Column("startTime")
	private Date startTime;
	
	//结束时间
	@Column("endTime")
	private Date endTime;

	//里程
	@Column("mileage")
	private String mileAge;
	
	//用时
	@Column("useTime")
	private String useTime;
	
	//平均速度
	@Column("aveSpeed")
	private String aveSpeed;
	
	//时刻
	@Column("moment")
	private String moment;
	
	//经度
	@Column("longitude")
	private String longitude;
	
	//纬度
	@Column("latitude")
	private String latitude;
	
	@Column("carid")
	private int carId;
	
	
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
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

	public String getMileAge() {
		return mileAge;
	}

	public void setMileAge(String mileAge) {
		this.mileAge = mileAge;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getAveSpeed() {
		return aveSpeed;
	}

	public void setAveSpeed(String aveSpeed) {
		this.aveSpeed = aveSpeed;
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

}
