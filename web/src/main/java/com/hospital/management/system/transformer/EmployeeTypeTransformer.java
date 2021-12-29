package com.hospital.management.system.transformer;

import java.util.ArrayList;
import java.util.List;

import com.hospital.management.system.dto.EmployeeTypeDTO;
import com.hospital.management.system.model.EmployeeTypeModel;

public class EmployeeTypeTransformer {
	public static EmployeeTypeModel getModel(EmployeeTypeDTO employeeTypeDTO) {
		EmployeeTypeModel employeeTypeModel=new EmployeeTypeModel();
		if(employeeTypeDTO.getId()!=null && !employeeTypeDTO.getId().equals("")) {
			employeeTypeModel.setId(Long.parseLong(employeeTypeDTO.getId()));
		}
		if(employeeTypeDTO.getEmployeeType()!=null && !employeeTypeDTO.getEmployeeType().equals("")) {
			employeeTypeModel.setEmployeeType(employeeTypeDTO.getEmployeeType());
		}
		return employeeTypeModel;
	}
	
	
	public static EmployeeTypeDTO getDTO(EmployeeTypeModel employeeTypeModel) {
		EmployeeTypeDTO employeeTypeDTO=new EmployeeTypeDTO();
		if(employeeTypeModel.getId()!=null && !employeeTypeModel.getId().equals("")) {
			employeeTypeDTO.setId(employeeTypeModel.getId().toString());
		}
		if(employeeTypeModel.getEmployeeType()!=null && !employeeTypeModel.getEmployeeType().equals("")) {
			employeeTypeDTO.setEmployeeType(employeeTypeModel.getEmployeeType());
		}
		return employeeTypeDTO;
	}
	
	public static List<EmployeeTypeDTO> getEmployeeTypeDTOs(List<EmployeeTypeModel> employeeTypeModels){
		List<EmployeeTypeDTO> employeeTypeDTOs=new ArrayList<EmployeeTypeDTO>();
		for(EmployeeTypeModel employeeTypeModel:employeeTypeModels) {
			employeeTypeDTOs.add(EmployeeTypeTransformer.getDTO(employeeTypeModel));
		}
		return employeeTypeDTOs;
	}
}
