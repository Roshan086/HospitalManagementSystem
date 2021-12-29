package com.hospital.management.system.dto;

import io.swagger.annotations.ApiModelProperty;

public class EmployeeTypeDTO extends AbstractDTO{
	@ApiModelProperty(value="Id",notes = "The database generated ID",hidden = true)
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
