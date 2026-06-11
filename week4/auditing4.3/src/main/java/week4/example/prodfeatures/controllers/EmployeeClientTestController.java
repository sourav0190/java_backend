package week4.example.prodfeatures.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import week4.example.prodfeatures.clients.EmployeeClient;
import week4.example.prodfeatures.dto.EmployeeDto;

import java.util.List;

@RestController
@RequestMapping("/client/employees")
@RequiredArgsConstructor
public class EmployeeClientTestController {

    private final EmployeeClient employeeClient;

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable Long employeeId) {
        return employeeClient.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeClient.createNewEmployee(employeeDto);
    }
}
