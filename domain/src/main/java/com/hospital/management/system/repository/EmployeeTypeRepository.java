package com.hospital.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.management.system.model.EmployeeTypeModel;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeModel, Long> {

}
