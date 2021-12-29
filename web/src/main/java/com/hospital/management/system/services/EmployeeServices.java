package com.hospital.management.system.services;

import com.hospital.management.system.model.EmployeeModel;

public interface EmployeeServices {
	public EmployeeModel saveEmployeeModel(EmployeeModel employeeModel);
	public EmployeeModel findByUserName(String userName);
	
}
