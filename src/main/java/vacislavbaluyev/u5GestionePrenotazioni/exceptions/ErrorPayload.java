package vacislavbaluyev.u5GestionePrenotazioni.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorPayload {
    private String message;
}
