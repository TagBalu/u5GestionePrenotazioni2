package vacislavbaluyev.u5GestionePrenotazioni.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.erros.ErrorsPayloadWithList;


import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorsPayloadWithList handleBadRequest(BadRequestException e) {
		List<String> errorsMessages = new ArrayList<>();
		if (e.getErrorsList() != null)
			errorsMessages = e.getErrorsList().stream().map(err -> err.getDefaultMessage()).toList();
		return new ErrorsPayloadWithList(e.getMessage(), errorsMessages);
	}
}
