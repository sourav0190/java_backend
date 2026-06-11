package week4.example.prodfeatures.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {

    // 🚀 MANDATORY TO UNDERSTAND:
    // It simply holds the HTTP Status (e.g. NOT_FOUND, BAD_REQUEST) and the descriptive error message.
    private HttpStatus status;
    private String message;
}
