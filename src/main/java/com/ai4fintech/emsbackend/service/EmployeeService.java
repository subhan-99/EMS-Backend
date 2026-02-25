package com.ai4fintech.emsbackend.service;

import java.util.List;

import com.ai4fintech.emsbackend.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List <EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
	
	void deleteEmployee(Long employeeId);
	
}
