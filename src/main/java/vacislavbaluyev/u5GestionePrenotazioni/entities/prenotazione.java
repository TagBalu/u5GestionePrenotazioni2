package vacislavbaluyev.u5GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "prenotazioni")
public class prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    protected Date dataPartenza;
    @Temporal(TemporalType.DATE)
    protected Date dataArrivo;
    protected String note;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private dipendente dipendente;
    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private viaggio viaggio;
}
