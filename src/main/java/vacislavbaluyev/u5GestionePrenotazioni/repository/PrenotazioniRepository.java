package vacislavbaluyev.u5GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vacislavbaluyev.u5GestionePrenotazioni.entities.prenotazione;

public interface PrenotazioniRepository extends JpaRepository<prenotazione, Integer>
{
}
