package com.hospital.management.system.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.system.dto.EmployeeDTO;
import com.hospital.management.system.dto.EmployeeTypeDTO;
import com.hospital.management.system.dto.StatusDTO;
import com.hospital.management.system.model.EmployeeTypeModel;
import com.hospital.management.system.services.EmployeeTypeServices;
import com.hospital.management.system.transformer.EmployeeTypeTransformer;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController("/employeeType/")
public class EmployeeTypeController {
	@Autowired
	private EmployeeTypeServices employeeTypeServices;
	
	@GetMapping(value = "allEmployeeTypes")
	public ResponseEntity<StatusDTO> allEmployeeTypes(){
		 try{
			 	List<EmployeeTypeModel> employeeTypeModels=employeeTypeServices.findAll();
	            return new ResponseEntity<>(new StatusDTO(1, "Find All ", EmployeeTypeTransformer.getEmployeeTypeDTOs(employeeTypeModels)), HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(new StatusDTO(0, "Exception occurred! "+e), HttpStatus.OK);
	        }
	}
	
	@PostMapping("saveEmployeeType")
	public ResponseEntity<StatusDTO> saveEmployeeType(@ModelAttribute EmployeeTypeDTO employeeTypeDTO){
		 try{
	            EmployeeTypeModel employeeTypeModel= EmployeeTypeTransformer.getModel(employeeTypeDTO);
	            employeeTypeModel.setStatus(true);
	            EmployeeTypeModel employee=employeeTypeServices.saveEmployeeType(employeeTypeModel);
	            return new ResponseEntity<>(new StatusDTO(1, "Employee Added Successfully ", EmployeeTypeTransformer.getDTO(employee)), HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(new StatusDTO(0, "Exception occurred! "+e), HttpStatus.OK);
	        }
	}
	
	@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "Employee Type Id ",readOnly = true, dataType = "string",paramType = "query",required = true),
	})
	@PostMapping("updateEmployeeType")
	public ResponseEntity<StatusDTO> updateEmployeeType(@ModelAttribute EmployeeTypeDTO employeeTypeDTO){
		 try{
	            EmployeeTypeModel employeeTypeModel= EmployeeTypeTransformer.getModel(employeeTypeDTO);
	            employeeTypeModel.setStatus(true);
	            EmployeeTypeModel employee=employeeTypeServices.saveEmployeeType(employeeTypeModel);
	            return new ResponseEntity<>(new StatusDTO(1, "Employee Update Successfully ", EmployeeTypeTransformer.getDTO(employee)), HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(new StatusDTO(0, "Exception occurred! "+e), HttpStatus.OK);
	        }
	}
	
	@GetMapping(value = "/deleteEmployeeType/{id}")
	public ResponseEntity<StatusDTO> deleteEmployeeType(@PathVariable Long id){
		 try{
	            EmployeeTypeModel employeeTypeModel= employeeTypeServices.findById(id);
	            employeeTypeModel.setStatus(false);
	            EmployeeTypeModel employee=employeeTypeServices.saveEmployeeType(employeeTypeModel);
	            return new ResponseEntity<>(new StatusDTO(1, "Employee Delete Successfully ", EmployeeTypeTransformer.getDTO(employee)), HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>(new StatusDTO(0, "Exception occurred! "+e), HttpStatus.OK);
	        }
	}
}
