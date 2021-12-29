package com.hospital.management.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.management.system.model.EmployeeTypeModel;
import com.hospital.management.system.repository.EmployeeTypeRepository;

@Service
public class EmployeeTypeServicesImpl implements EmployeeTypeServices {

	@Autowired
	EmployeeTypeRepository employeeTypeRepository;
	
	@Override
	public EmployeeTypeModel saveEmployeeType(EmployeeTypeModel employeeTypeModel) {
		// TODO Auto-generated method stub
		return employeeTypeRepository.save(employeeTypeModel);
	}

	@Override
	public EmployeeTypeModel updateEmployeeType(EmployeeTypeModel employeeTypeModel) {
		// TODO Auto-generated method stub
		return employeeTypeRepository.save(employeeTypeModel);
	}

	@Override
	public EmployeeTypeModel deleteEmployeeType(EmployeeTypeModel employeeTypeModel) {
		// TODO Auto-generated method stub
		return employeeTypeRepository.save(employeeTypeModel);
	}

	@Override
	public EmployeeTypeModel findById(Long employeeTypeId) {
		// TODO Auto-generated method stub
		Optional<EmployeeTypeModel> optional=employeeTypeRepository.findById(employeeTypeId);
		if (optional.isPresent()) {
            return optional.get();
        }
        return null;
	}

	@Override
	public List<EmployeeTypeModel> findAll() {
		// TODO Auto-generated method stub
		return employeeTypeRepository.findAll();
	}

}
