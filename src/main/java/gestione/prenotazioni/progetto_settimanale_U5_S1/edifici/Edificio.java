package gestione.prenotazioni.progetto_settimanale_U5_S1.edifici;

import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.Postazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
//@AllArgsConstructor commentato perchè implementato un costruttore più specifico
@NoArgsConstructor
@Table(name = "edifici")

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long edificio_id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String indirizzo;

    @Column(nullable = false, length = 100)
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    public Edificio(String indirizzo, String nome, String citta) {
        this.indirizzo = indirizzo;
        this.nome = nome;
        this.citta = citta;
    }
}