package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee.dto.EmployeeDetailsDTO;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeWebController {
	
	@Autowired
	private EmployeeService employeeService;
	
	  @GetMapping
	    public String showEmployeePage(Model model, Authentication authentication) {
	        List<Employee> employees = employeeService.fetchEmployeePage(); 
	        model.addAttribute("employees", employees);
	        model.addAttribute("role", authentication.getAuthorities().iterator().next().getAuthority());
	        return "employee";
	    }
	 
}
