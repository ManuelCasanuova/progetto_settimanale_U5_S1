package gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni;

import gestione.prenotazioni.progetto_settimanale_U5_S1.edifici.Edificio;
import gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "postazioni")

public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postazione_id;

    @Column(length = 150)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipoPostazione;

    private int numeroMassimoOccupanti;

    @ManyToOne
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String descrizione, TipoPostazione tipoPostazione, int numeroMassimoOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "\n" + descrizione + '\n' +
                "Tipo postazione: " + tipoPostazione + "\n" +
                "Numero massimo di occupanti: " + numeroMassimoOccupanti;
    }
}