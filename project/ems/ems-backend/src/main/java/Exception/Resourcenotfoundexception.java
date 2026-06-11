package Exception;

import com.example.ems_backend.Dto.EmployeeDto;
import org.aspectj.bridge.IMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourcenotfoundexception extends Exception{


    public Resourcenotfoundexception(String message) {
        super(message);
    }
}
