package com.ai4fintech.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ai4fintech.emsbackend.dto.EmployeeDto;
import com.ai4fintech.emsbackend.entity.Employee;
import com.ai4fintech.emsbackend.exception.ResourceNotFoundException;
import com.ai4fintech.emsbackend.mapper.EmployeeMapper;
import com.ai4fintech.emsbackend.repository.EmployeeRepository;
import com.ai4fintech.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee is not exists with given id : " + employeeId
                        ));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
		.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		
		
	Employee employee =	employeeRepository.findById(employeeId).orElseThrow(
				()-> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
		);
	
	    
	    employee.setFirstName(updateEmployee.getFirstName());
	    employee.setLastName(updateEmployee.getLastName());
	    employee.setEmail(updateEmployee.getEmail());
	    
	    Employee updatedEmployeeObj = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		 Employee employee = employeeRepository.findById(employeeId) .orElseThrow(() ->
	                        new ResourceNotFoundException(
	                                "Employee is not exists with given id : " + employeeId));
		 
		 employeeRepository.deleteById(employeeId);
		}
}