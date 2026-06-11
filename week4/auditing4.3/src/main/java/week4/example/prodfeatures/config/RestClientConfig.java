package week4.example.prodfeatures.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {
    
    @Value("${employeeserviceurl}")
    private String baseUrl;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(baseUrl) // Set the target service's base URL here
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                // You can also add authorization interceptors or basic auth credentials here if needed
                .build();
    }
}
