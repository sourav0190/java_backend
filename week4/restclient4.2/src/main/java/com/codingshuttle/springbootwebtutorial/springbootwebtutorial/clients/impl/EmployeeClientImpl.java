package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.clients.impl;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.clients.EmployeeClient;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.advices.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class EmployeeClientImpl implements EmployeeClient {

    private static final Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);
    private final RestClient restClient;

    public EmployeeClientImpl(@Qualifier("employeeRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Fetching all employees via RestClient...");
        try {
            ApiResponse<List<EmployeeDTO>> response = restClient.get()
                    .uri("/employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDTO>>>() {});
            return response.getData();
        } catch (Exception e) {
            log.error("Error fetching all employees: {}", e.getMessage());
            throw new RuntimeException("Failed to fetch employees: " + e.getMessage());
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.info("Fetching employee with id: {} via RestClient...", employeeId);
        try {
            ApiResponse<EmployeeDTO> response = restClient.get()
                    .uri("/employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (request, response2) -> {
                        log.error("Client error occurred while fetching employee with id: {}", employeeId);
                        throw new RuntimeException("Employee not found with id: " + employeeId);
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});
            return response.getData();
        } catch (Exception e) {
            log.error("Error fetching employee by id: {}", e.getMessage());
            throw new RuntimeException("Failed to fetch employee: " + e.getMessage());
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.info("Creating new employee: {} via RestClient...", employeeDTO);
        try {
            ApiResponse<EmployeeDTO> response = restClient.post()
                    .uri("/employees")
                    .body(employeeDTO)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});
            return response.getData();
        } catch (Exception e) {
            log.error("Error creating employee: {}", e.getMessage());
            throw new RuntimeException("Failed to create employee: " + e.getMessage());
        }
    }

    @Override
    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        log.info("Updating employee with id: {} via RestClient...", employeeId);
        try {
            ApiResponse<EmployeeDTO> response = restClient.put()
                    .uri("/employees/{employeeId}", employeeId)
                    .body(employeeDTO)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});
            return response.getData();
        } catch (Exception e) {
            log.error("Error updating employee: {}", e.getMessage());
            throw new RuntimeException("Failed to update employee: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        log.info("Deleting employee with id: {} via RestClient...", employeeId);
        try {
            restClient.delete()
                    .uri("/employees/{employeeId}", employeeId)
                    .retrieve()
                    .toBodilessEntity();
        } catch (Exception e) {
            log.error("Error deleting employee: {}", e.getMessage());
            throw new RuntimeException("Failed to delete employee: " + e.getMessage());
        }
    }
}
