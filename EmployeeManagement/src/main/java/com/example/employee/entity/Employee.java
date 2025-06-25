package com.example.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="EmpID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empID;
	
	@Column(name="Name")
	private String name;
	
	@Column(name = "Email", unique = true, nullable = false)
    private String email;
	
	@Column(name="Department")
	private String department;
	
	@Column(name="Salary")
	private Integer salary;
	

}
