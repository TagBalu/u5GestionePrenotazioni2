package vacislavbaluyev.u5GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vacislavbaluyev.u5GestionePrenotazioni.entities.dipendente;

import java.util.Optional;

@Repository
public interface DipendentiRepository extends JpaRepository<dipendente , Integer> {
    Optional<dipendente> findByEmail(String email);
}
