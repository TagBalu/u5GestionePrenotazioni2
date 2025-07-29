package vacislavbaluyev.u5GestionePrenotazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;
import vacislavbaluyev.u5GestionePrenotazioni.exceptions.UnauthorizedException;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.LoginDTO;
import vacislavbaluyev.u5GestionePrenotazioni.tools.JWWTools;

@Service
public class AuthService {

    @Autowired
    private DipendentiService DipendentiService;

    @Autowired
    private JWWTools jwwTools;

    public String checkAndGenerate(LoginDTO body) {
        dipendente found = this.DipendentiService.findByEmail(body.email());

        if (found.getPassword().equals(body.password())) {
        } else {
            throw new UnauthorizedException("Credenziali sbaglaite!")
        }
    }
}
