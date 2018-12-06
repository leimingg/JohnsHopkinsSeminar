package model;

import java.io.Serializable;
import java.util.List;

public class RegistrationInfo implements Serializable{
	private String name="";
	private String email="";
	private List<String> courses;
	private String employmentStatus;
	private String hotel;
	private String parking;
	private CostInformation costInfo;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public String getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public CostInformation getCostInfo() {
		return costInfo;
	}
	public void setCostInfo(CostInformation costInfo) {
		this.costInfo = costInfo;
	}
	public RegistrationInfo(String name, String email, List<String> courses, String employmentStatus, String hotel,
			String parking) {
		super();
		this.name = name;
		this.email = email;
		this.courses = courses;
		this.employmentStatus = employmentStatus;
		this.hotel = hotel;
		this.parking = parking;
		
	}
	public RegistrationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
