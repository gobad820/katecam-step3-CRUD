package katecam.step3.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiDto<T> {
    private T data;
    private String message;
    private HttpStatus status;
}
