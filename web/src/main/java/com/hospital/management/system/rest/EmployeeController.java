package com.hospital.management.system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.system.dto.EmployeeDTO;
import com.hospital.management.system.dto.StatusDTO;
import com.hospital.management.system.model.EmployeeModel;
import com.hospital.management.system.services.EmployeeServices;
import com.hospital.management.system.transformer.EmployeeTransformer;

@RestController("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServices employeeServices;
	
	//creating post mapping that save the Employee detail in the database
	 @PostMapping("/saveEmployee")
	    private ResponseEntity<StatusDTO> saveEmployee(@ModelAttribute EmployeeDTO employeeDTO)
	    {
	        try{
	            EmployeeModel employeeModel= EmployeeTransformer.getModel(employeeDTO);
	            EmployeeModel employee=employeeServices.saveEmployeeModel(employeeModel);
	            return new ResponseEntity<>(new StatusDTO(1, "Employee Added Successfully ", EmployeeTransformer.getDTO(employee)), HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(new StatusDTO(0, "Exception occurred! "+e), HttpStatus.OK);
	        }
	    }
}
