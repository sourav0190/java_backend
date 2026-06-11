import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import java.util.List;

/**
 * Note: To compile successfully under standard Maven structure,
 * this interface should be placed under src/main/java.
 * I have created the standard version for you at:
 * src/main/java/com/codingshuttle/springbootwebtutorial/springbootwebtutorial/clients/EmployeeClient.java
 */
public interface EmployeeClientimpl {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO);

    void deleteEmployeeById(Long employeeId);
}
