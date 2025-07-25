package vacislavbaluyev.u5GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String destinazione;

    @Temporal(TemporalType.DATE)
    private Date dataPartenza;

    @Temporal(TemporalType.DATE)
    private Date dataArrivo;

    private String stato;
}
