package week4.example.prodfeatures.advice;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    // 🚀 MANDATORY TO UNDERSTAND:
    // This is a generic wrapper. 'T data' means it can hold a List, a single DTO, a String, or anything else!
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
