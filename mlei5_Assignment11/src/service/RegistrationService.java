package service;

import java.util.List;

import model.CostInformation;
import model.RegistrationInfo;

public interface RegistrationService {
	public RegistrationInfo getRegistrationInfo();

	public void setRegistrationInfo(String name, String email, List<String> courses, String employmentStatus,
			String hotel, String parking);

	public CostInformation getCostInfo();

	public void removeCourse(String course);

	public String[] getCourses();
	

}
