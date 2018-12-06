package model;

import java.io.Serializable;

public class CostInformation implements Serializable{
	public static final double EMPLOYEE = 850.00;
	public static final double STUDENT = 1000.00;
	public static final double SPEAKER = 0.00;
	public static final double OTHER = 1350.00;
	public static final double HOTEL = 185.00;
	public static final double PARKING = 10.00;
	private double hotelCost=185.00;
	private double parkingCost=10.00;
	private double employeeStatusCost;
	private double total;
	
	
	public double getEmployeeStatusCost() {
		return employeeStatusCost;
	}
	public void setEmployeeStatusCost(double employeeStatusCost) {
		this.employeeStatusCost = employeeStatusCost;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getHotelCost() {
		return hotelCost;
	}
	public void setHotelCost(double hotelCost) {
		this.hotelCost = hotelCost;
	}
	public double getParkingCost() {
		return parkingCost;
	}
	public void setParkingCost(double parkingCost) {
		this.parkingCost = parkingCost;
	}
	public CostInformation(double hotelCost, double parkingCost, double employeeStatusCost, double total) {
		super();
		this.hotelCost = hotelCost;
		this.parkingCost = parkingCost;
		this.employeeStatusCost = employeeStatusCost;
		this.total = total;
	}
	public CostInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
