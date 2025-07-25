package vacislavbaluyev.u5GestionePrenotazioni.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;
import vacislavbaluyev.u5GestionePrenotazioni.exceptions.BadRequestException;
import vacislavbaluyev.u5GestionePrenotazioni.exceptions.NotFoundException;
import vacislavbaluyev.u5GestionePrenotazioni.payloads.dipendenti.NewDipendenteDTO;
import vacislavbaluyev.u5GestionePrenotazioni.repository.DipendentiRepository;

import java.util.List;

@Service
@Slf4j
public class DipendentiService {

    @Autowired
    private DipendentiRepository dipendentiRepository;

    public List<dipendente> getAll() {
        return dipendentiRepository.findAll();
    }


    public dipendente save (NewDipendenteDTO payload){
        this.dipendentiRepository.findByEmail(payload.email()).ifPresent(dipendente ->{
            throw new BadRequestException("L'email" + dipendente.getEmail()+ "è già in uso!");
        } );
        dipendente newDipendente = new dipendente(payload.nome(),payload.cognome(),payload.email());
        dipendente savedDipendente= this.dipendentiRepository.save(newDipendente);
        log.info("Dipendente"+ savedDipendente.getId() +"creato con successo!");
        
        return savedDipendente;
    }

    public dipendente findById(int id) {
        return dipendentiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dipendente con id " + id + " non trovato"));
    }


    public void findAndDeleteById(int id) {
        dipendente found = this.findById(id);
        dipendentiRepository.delete(found);
    }


}
