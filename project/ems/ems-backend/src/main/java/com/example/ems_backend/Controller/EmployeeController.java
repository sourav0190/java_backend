package com.example.ems_backend.Controller;

import com.example.ems_backend.Dto.EmployeeDto;
import com.example.ems_backend.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }

    @PostMapping()
    public ResponseEntity<EmployeeDto> CreateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee1 = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeebyid(@PathVariable("id") long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(
            @PathVariable("id") Long id,
            @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.noContent().build();
    }

}
