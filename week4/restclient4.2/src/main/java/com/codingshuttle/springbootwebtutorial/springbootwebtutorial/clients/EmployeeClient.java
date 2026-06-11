package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.clients;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO);

    void deleteEmployeeById(Long employeeId);
}
