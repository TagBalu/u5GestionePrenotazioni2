package vacislavbaluyev.u5GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vacislavbaluyev.u5GestionePrenotazioni.entities.viaggio;

public interface ViaggiRepository extends JpaRepository<viaggio, Integer>
{
}
