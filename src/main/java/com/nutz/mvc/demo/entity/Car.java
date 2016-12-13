package com.nutz.mvc.demo.entity;

import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 车辆信息
 * @author admin
 *
 */
@Table("t_carinfo")
public class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//车辆id
	@Id
	@Column("carid")
	private int carId;
	
	//车辆品牌
	@Column("brand")
	private String brand;
	
	//车型
	@Column("carType")
	private String carType;
	
	//车牌号
	@Column("carNum")
	private String carNum;
	
	//车架号
	@Column("VIN")
	private String vin;
	
	//车辆照片
	@Column("photo")
	private String photo;
	
	@Column("uid")
	private int uId;
	
	@One(target = User.class , field = "uId")
	private User user;
	
	@Many(target = ReportVehicleInfo.class , field = "carId")
	private List<ReportVehicleInfo> reportVehicleInfos;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ReportVehicleInfo> getReportVehicleInfos() {
		return reportVehicleInfos;
	}

	public void setReportVehicleInfos(List<ReportVehicleInfo> reportVehicleInfos) {
		this.reportVehicleInfos = reportVehicleInfos;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}
}
