package week4.example.prodfeatures.clients;

import week4.example.prodfeatures.dto.EmployeeDto;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long employeeId);
    EmployeeDto createNewEmployee(EmployeeDto  employeeDto) ;
}
