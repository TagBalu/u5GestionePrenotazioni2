package vacislavbaluyev.u5GestionePrenotazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;
import vacislavbaluyev.u5GestionePrenotazioni.exceptions.BadRequestException;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.NewDipendenteDTO;
import vacislavbaluyev.u5GestionePrenotazioni.repository.DipendentiRepository;

@Service
public class DipendentiService {

    @Autowired
    private DipendentiRepository dipendentiRepository;

    public dipendente save(NewDipendenteDTO body) throws Exception {
        dipendentiRepository.findByEmail(body.email()).ifPresent(user->{
            throw new BadRequestException("L'email " + body.email()+ "é già stata utilizzata");
        });
        dipendente newDipendente = new dipendente();
        newDipendente.setNome(body.nome());
        newDipendente.setCognome(body.cognome());
        newDipendente.setEmail(body.email());
        return dipendentiRepository.save(newDipendente);
    }
}
