package com.hospital.management.system.transformer;

import com.hospital.management.system.dto.EmployeeDTO;
import com.hospital.management.system.model.EmployeeModel;
import com.hospital.management.system.utill.EncoderDecoder;

public class EmployeeTransformer {
	
	public static EmployeeModel getModel(EmployeeDTO employeeDTO) {
		EmployeeModel employeeModel=new EmployeeModel();
		if(employeeDTO.getUserName()!=null && !employeeDTO.getUserName().equals("")) {
			employeeModel.setUserName(employeeDTO.getUserName());
		}
		
		if(employeeDTO.getPassword()!=null && !employeeDTO.getPassword().equals("")) {
			employeeModel.setPassword(EncoderDecoder.getEncryptedSHA1Password(employeeDTO.getPassword().trim()));
		}
		if(employeeDTO.getAddress()!=null && !employeeDTO.getAddress().equals("")) {
			employeeModel.setAddress(employeeDTO.getAddress());
		}
		
		return employeeModel;
	}
	
	public static EmployeeDTO getDTO(EmployeeModel employeeModel) {
		EmployeeDTO employeeDTO=new EmployeeDTO();
		if(employeeModel.getId()!=null) {
			employeeDTO.setId(employeeModel.getId().toString());
		}
		if(employeeModel.getUserName()!=null && !employeeModel.getUserName().equals("")) {
			employeeDTO.setUserName(employeeModel.getUserName());
		}
		if(employeeModel.getPassword()!=null && !employeeModel.getPassword().equals("")) {
			employeeDTO.setPassword(employeeModel.getPassword());
		}
		if(employeeModel.getAddress()!=null && !employeeModel.getAddress().equals("")) {
			employeeDTO.setAddress(employeeModel.getAddress());
		}
		
		return employeeDTO;
	}
}
