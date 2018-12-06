package service;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import model.CostInformation;
import model.RegistrationInfo;

public class RegistrationServiceImplement implements RegistrationService,Serializable {

	private RegistrationInfo registrationInfo;
	private RegistrationServiceImplement regSrv;

	public RegistrationServiceImplement() {
		registrationInfo = new RegistrationInfo();
	}

	@Override
	public RegistrationInfo getRegistrationInfo() {
		// TODO Auto-generated method stub
		return registrationInfo;
	}
	
	

	@Override
	public void setRegistrationInfo(String name, String email, List<String> courses, String employmentStatus,
			String hotel, String parking) {
		// TODO Auto-generated method stub
		registrationInfo.setName(name);
		registrationInfo.setEmail(email);
		registrationInfo.setCourses(courses);
		registrationInfo.setEmploymentStatus(employmentStatus);
		registrationInfo.setHotel(hotel);
		registrationInfo.setParking(parking);
		registrationInfo.setCostInfo(calculateCostInfo());

	}
	

	@Override
	public CostInformation getCostInfo() {
		// TODO Auto-generated method stub
		return registrationInfo.getCostInfo();
	}
	
	@Override
	public void removeCourse(String course) {
		// TODO Auto-generated method stub
		// remove the course
		List<String> courses = new LinkedList<String>();
		courses.addAll(registrationInfo.getCourses());
		courses.remove(course);
		registrationInfo.setCourses(courses);

		// calculate new cost information after removing
		registrationInfo.setCostInfo(calculateCostInfo());

	}

	public CostInformation calculateCostInfo() {
		CostInformation costInfo = new CostInformation();

		String employmentStatus = registrationInfo.getEmploymentStatus();
		if (employmentStatus.equals("JHU Employee")) {
			costInfo.setEmployeeStatusCost(CostInformation.EMPLOYEE);
		} else if (employmentStatus.equals("JHU Student")) {
			costInfo.setEmployeeStatusCost(CostInformation.STUDENT);
		} else if (employmentStatus.equals("Speaker")) {
			costInfo.setEmployeeStatusCost(CostInformation.SPEAKER);
		} else if (employmentStatus.equals("Other")) {
			costInfo.setEmployeeStatusCost(CostInformation.OTHER);
		}

		// calculate total cost
		double total = 0.0;

		List<String> courses = registrationInfo.getCourses();
		// calculate cost based on user's employment status
		total = costInfo.getEmployeeStatusCost() * courses.size();

		//Add hotel cost to total cost if user select hotel
		if (!StringUtils.isEmpty(registrationInfo.getHotel())) {
			total = total + CostInformation.HOTEL;
		}

		//Add parking cost to total cost if user select parking
		if (!StringUtils.isEmpty(registrationInfo.getParking())) {
			total = total + CostInformation.PARKING;
		}

		costInfo.setTotal(total);

		return costInfo;
	}
	
	

	@Override
	public String[] getCourses() {
		String[] courses = new String[registrationInfo.getCourses().size()];

		return registrationInfo.getCourses().toArray(courses);
	}

	public String getName() {
		return registrationInfo.getName();
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return registrationInfo.getEmail();
	}

	public String getEmploymentStatus() {
		// TODO Auto-generated method stub
		return registrationInfo.getEmploymentStatus();
	}

//	public double getTotal() {
//		CostInformation cost = regSrv.calculateCostInfo();
//		double totalCost=Double.parseDouble(cost.toString());
//		return totalCost;
//	}

}
