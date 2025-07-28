package vacislavbaluyev.u5GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "dipendenti")
public class dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    protected String nome;
    protected String cognome;
    protected String email;
    protected String password;

    public dipendente(String nome, String cognome, String email,String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password=password;
    }
}
