package com.example.ems_backend.Service;

import com.example.ems_backend.Dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto employeeDto);
    void deleteEmployee(Long employeeId);

}