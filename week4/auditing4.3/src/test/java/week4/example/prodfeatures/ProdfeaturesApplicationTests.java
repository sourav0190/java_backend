package week4.example.prodfeatures;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import week4.example.prodfeatures.clients.EmployeeClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProdfeaturesApplicationTests {

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void getAllEmployees() {

		assertThat(employeeClient).isNotNull();

		var employees = employeeClient.getAllEmployees();

		assertThat(employees).isNotNull();

		System.out.println(employees);
	}
}