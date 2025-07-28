package vacislavbaluyev.u5GestionePrenotazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;
import vacislavbaluyev.u5GestionePrenotazioni.exceptions.UnauthorizedException;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.LoginDTO;

@Service
public class PublicService {

    @Autowired
    private DipendentiService DipendentiService;

    public String checkAndGenerate(LoginDTO body) {
        dipendente found = this.DipendentiService.findByEmail(body.email());

        if (found.getPassword().equals(body.password())) {
        } else {
            throw new UnauthorizedException("Credenziali sbaglaite!")
        }
    }
}
