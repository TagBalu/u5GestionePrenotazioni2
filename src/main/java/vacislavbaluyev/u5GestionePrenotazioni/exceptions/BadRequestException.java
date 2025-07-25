package vacislavbaluyev.u5GestionePrenotazioni.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public List<ObjectError> errorsList;

    public BadRequestException(List<ObjectError> errorsList) {
        super("Errori nel body");
        this.errorsList = errorsList;
    }
}
