package com.hospital.management.system.dto;


public class EmployeeTypeDTO extends AbstractDTO{
	private String id;
	private String employeeType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
}
