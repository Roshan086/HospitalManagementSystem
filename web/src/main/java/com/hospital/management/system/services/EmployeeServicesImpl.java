package com.hospital.management.system.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.system.model.EmployeeModel;
import com.hospital.management.system.repository.EmployeeRepository;

@Service
public class EmployeeServicesImpl implements EmployeeServices{
	
	
	  @Autowired 
	  EmployeeRepository employeeRepository;
	 
	@Override
	public EmployeeModel saveEmployeeModel(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeModel);
	}

	@Override
	public EmployeeModel findByUserName(String userName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUserName(userName);
	}
	
}
