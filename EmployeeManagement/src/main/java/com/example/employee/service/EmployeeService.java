package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Employee;

public interface EmployeeService {

	void addEmployee(EmployeeDetailsDTO employeeDetailsDTO);

	void updateEmployee(EmployeeDetailsDTO employeeDetailsDTO);

	void deleteEmployee(Integer empID);

	EmployeeDetailsDTO fetchEmployee(Integer empID);

	List<EmployeeDetailsDTO> fetchEmployees();

	List<Employee> fetchEmployeePage();

}
