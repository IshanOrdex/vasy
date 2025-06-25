package com.example.employee.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

@Repository
@Transactional
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	Employee findByEmpID(Integer empID);
	

}
