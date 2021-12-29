package com.hospital.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.system.model.EmployeeModel;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
	EmployeeModel findByUserNameAndPassword(String userName,String password);
	EmployeeModel findByUserName(String userName);
}
