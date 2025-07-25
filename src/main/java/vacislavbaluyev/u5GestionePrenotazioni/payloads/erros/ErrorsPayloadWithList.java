package vacislavbaluyev.u5GestionePrenotazioni.payloads.erros;

import java.util.List;

public record ErrorsPayloadWithList(
        String messaggio,
        List<String> errorsList
) {
}
