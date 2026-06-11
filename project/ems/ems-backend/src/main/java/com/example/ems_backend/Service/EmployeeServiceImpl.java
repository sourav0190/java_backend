package com.example.ems_backend.Service;


import com.example.ems_backend.Dto.EmployeeDto;
import com.example.ems_backend.Entity.Employee;
import com.example.ems_backend.Mapper.EmployeeMapper;
import com.example.ems_backend.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + employeeId)
                );

        return employeeMapper.toDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {

        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + employeeId)
                );

        // 🔥 MapStruct will update existing entity
        employeeMapper.updateEmployeeFromDto(employeeDto, employee);

        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + employeeId)
                );
        employeeRepository.deleteById(employeeId);

    }


}