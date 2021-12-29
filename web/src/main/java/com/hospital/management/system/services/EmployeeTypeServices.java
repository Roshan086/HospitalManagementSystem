package com.hospital.management.system.services;

import java.util.List;

import com.hospital.management.system.model.EmployeeTypeModel;

public interface EmployeeTypeServices {
	public EmployeeTypeModel saveEmployeeType(EmployeeTypeModel employeeTypeModel);
	public EmployeeTypeModel updateEmployeeType(EmployeeTypeModel employeeTypeModel);
	public EmployeeTypeModel deleteEmployeeType(EmployeeTypeModel employeeTypeModel);
	public EmployeeTypeModel findById(Long employeeTypeId);
	public List<EmployeeTypeModel> findAll();
}
