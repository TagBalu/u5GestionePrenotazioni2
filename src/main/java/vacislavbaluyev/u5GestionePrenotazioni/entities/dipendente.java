package vacislavbaluyev.u5GestionePrenotazioni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected String nome;
    protected String cognome;
    protected String email;
}
