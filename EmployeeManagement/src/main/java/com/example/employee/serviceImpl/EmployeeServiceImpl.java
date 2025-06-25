package com.example.employee.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dao.EmployeeDAO;
import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public void addEmployee(EmployeeDetailsDTO employeeDetailsDTO) {
		
		LOGGER.info("In EmployeeServiceImpl -> registerEmployee Method");
		
		Employee employee = new Employee();
		
		BeanUtils.copyProperties(employeeDetailsDTO, employee);
		
		employeeDAO.save(employee);
		
		LOGGER.info("Exiting EmployeeServiceImpl -> registerEmployee Method");
	}

	@Override
	public void updateEmployee(EmployeeDetailsDTO employeeDetailsDTO) {
		
		LOGGER.info("In EmployeeServiceImpl -> updateEmployee Method");
		
		if (employeeDetailsDTO.getEmpID() != null) {
			Employee employee = employeeDAO.findByEmpID(employeeDetailsDTO.getEmpID());

			BeanUtils.copyProperties(employeeDetailsDTO, employee);

			employeeDAO.save(employee);
		}
		
		LOGGER.info("Exiting EmployeeServiceImpl -> updateEmployee Method");
	}

	@Override
	public void deleteEmployee(Integer empID) {
		
		LOGGER.info("In EmployeeServiceImpl -> deleteEmployee Method");
		
		employeeDAO.deleteById(empID);
		
		LOGGER.info("Exiting EmployeeServiceImpl -> deleteEmployee Method");
	}

	@Override
	public EmployeeDetailsDTO fetchEmployee(Integer empID) {

		LOGGER.info("In EmployeeServiceImpl -> fetch Employee details Method");

		EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();

		Employee employee = employeeDAO.findByEmpID(empID);

		if (employee != null) {

			BeanUtils.copyProperties(employee, employeeDetailsDTO);

		}
		LOGGER.info("Exiting EmployeeServiceImpl -> fetch Employee details Method");
		return employeeDetailsDTO;

	}

	@Override
	public List<EmployeeDetailsDTO> fetchEmployees() {

		LOGGER.info("In EmployeeServiceImpl -> fetch Employees details Method");

		List<EmployeeDetailsDTO> employeeDetailsDTOs = new ArrayList<>();

		List<Employee> employee = employeeDAO.findAll();

		for (Employee emp : employee) {

			EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();

			BeanUtils.copyProperties(emp, employeeDetailsDTO);

			employeeDetailsDTOs.add(employeeDetailsDTO);
		}

		LOGGER.info("Exiting EmployeeServiceImpl -> fetch Employees details Method");
		return employeeDetailsDTOs;
	}

	@Override
	public List<Employee> fetchEmployeePage() {
		
		List<Employee> employee = employeeDAO.findAll();
		
		return employee;
		
	}

	
}
