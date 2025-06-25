package com.example.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.dto.ResponseDTO;
import com.example.employee.service.EmployeeService;

@Controller
@RequestMapping("/rest/employees")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/register")
	public ResponseDTO employee(@RequestBody EmployeeDetailsDTO employeeDetailsDTO) {

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info("In EmployeeController -> add employee API");

			employeeService.addEmployee(employeeDetailsDTO);

			responseDTO.setServiceResult("Employee details saved successfully");
			responseDTO.setMessage("Employee details saved successfully");
			responseDTO.setSuccess(1);

			LOGGER.info("Exiting EmployeeController -> add employee API");

		} catch (Exception ex) {

			responseDTO.setServiceResult("Error occurred while saving employee details");
			responseDTO.setMessage("Error occurred while saving employee details");
			responseDTO.setSuccess(0);
		}

		return responseDTO;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/edit")
	public ResponseDTO editEmployee(@RequestBody EmployeeDetailsDTO employeeDetailsDTO) {

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info("In EmployeeController -> update employee API");

			employeeService.updateEmployee(employeeDetailsDTO);

			responseDTO.setServiceResult("Employee details updated successfully");
			responseDTO.setMessage("Employee details updated successfully");
			responseDTO.setSuccess(1);

			LOGGER.info("Exiting EmployeeController -> update employee API");

		} catch (Exception ex) {

			responseDTO.setServiceResult("Error occurred while updating employee details");
			responseDTO.setMessage("Error occurred while updating employee details");
			responseDTO.setSuccess(0);
		}

		return responseDTO;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete")
	public ResponseDTO deleteEmployee(@RequestParam("empID") Integer empID) {

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info("In EmployeeController -> delete employee API");

			employeeService.deleteEmployee(empID);

			responseDTO.setServiceResult("Employee details deleted successfully");
			responseDTO.setMessage("Employee details deleted successfully");
			responseDTO.setSuccess(1);

			LOGGER.info("Exiting EmployeeController -> delete employee API");

		} catch (Exception ex) {

			responseDTO.setServiceResult("Error occurred while deleting employee details");
			responseDTO.setMessage("Error occurred while deleting employee details");
			responseDTO.setSuccess(0);
		}

		return responseDTO;
	}
	
	@GetMapping("/detail")
	public ResponseDTO fetchEmployee(@RequestParam("empID") Integer empID) {

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info("In EmployeeController -> Fetch employee details API");

			EmployeeDetailsDTO employeeDetailsDTO=employeeService.fetchEmployee(empID);

			responseDTO.setServiceResult(employeeDetailsDTO);
			responseDTO.setMessage("Employee details fetched successfully");
			responseDTO.setSuccess(1);

			LOGGER.info("Exiting EmployeeController -> Fetch employee details API");

		} catch (Exception ex) {

			responseDTO.setServiceResult("Error occurred while fetching employee details");
			responseDTO.setMessage("Error occurred while fetching employee details");
			responseDTO.setSuccess(0);
		}

		return responseDTO;
	}
	
	@GetMapping("/details")
	public ResponseDTO fetchEmployees() {

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			LOGGER.info("In EmployeeController -> Fetch employees details API");

			List<EmployeeDetailsDTO> employeeDetailsDTO=employeeService.fetchEmployees();

			responseDTO.setServiceResult(employeeDetailsDTO);
			responseDTO.setMessage("Employees details fetched successfully");
			responseDTO.setSuccess(1);

			LOGGER.info("Exiting EmployeeController -> Fetch employees details API");

		} catch (Exception ex) {

			responseDTO.setServiceResult("Error occurred while fetching employees details");
			responseDTO.setMessage("Error occurred while fetching employees details");
			responseDTO.setSuccess(0);
		}

		return responseDTO;
	}
	
}