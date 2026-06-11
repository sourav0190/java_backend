package week4.example.prodfeatures.clients.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import week4.example.prodfeatures.advice.ApiResponse;
import week4.example.prodfeatures.clients.EmployeeClient;
import week4.example.prodfeatures.dto.EmployeeDto;
import week4.example.prodfeatures.exceptions.ResourceNotFoundException;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 🚀 MANDATORY TO UNDERSTAND:
// We mark this class with @Service so Spring registers it as a Bean.
@Service
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;
    private static final Logger log =
            LoggerFactory.getLogger(EmployeeClientImpl.class);


    // 🚀 MANDATORY TO UNDERSTAND:
    // We inject the RestClient bean via the constructor.
    public EmployeeClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        // ♻️ Reusable: Standard try-catch block
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");


        try {
            // 🚀 MANDATORY TO UNDERSTAND:
            // This is how you execute a GET request.
            // Since the server wraps results, we retrieve 'ApiResponse<List<EmployeeDto>>'
            ApiResponse<List<EmployeeDto>> response = restClient.get()
                    .uri("employees") // Target URL path (appends to baseUrl)
                    .retrieve()       // Sends request
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new ResourceNotFoundException("Could not retrieve employees");
                    })
                    // 🚀 MANDATORY TO UNDERSTAND:
                    // Using ParameterizedTypeReference is required when returning lists/nested generics
                    .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDto>>>() {});

            return response.getData(); // Extracts and returns List<EmployeeDto>
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employees", e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        try {
            // 🚀 MANDATORY TO UNDERSTAND:
            // Path parameters are passed in the uri() method after the string:
            ApiResponse<EmployeeDto> response = restClient.get()
                    .uri("employees/{employeeId}", employeeId) // {employeeId} is dynamically replaced
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDto>>() {});

            return response.getData();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee", e);
        }
    }

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        try {
            // 🚀 MANDATORY TO UNDERSTAND:
            // This is how you execute a POST request. You must pass the body before retrieve()
            ApiResponse<EmployeeDto> response = restClient.post()
                    .uri("employees")
                    .body(employeeDto) // Sends the object data as JSON payload
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new ResourceNotFoundException("Could not create employee");
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDto>>() {});

            return response.getData();
        } catch (Exception e) {
            throw new RuntimeException("Error creating employee", e);
        }
    }
}
