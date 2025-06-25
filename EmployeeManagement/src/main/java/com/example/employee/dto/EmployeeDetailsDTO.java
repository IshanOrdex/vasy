package com.example.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDetailsDTO {
	
	private Integer empID;
	
	private String name;
	
	private String email;
	
	private String department;
	
	private Integer salary;

}
