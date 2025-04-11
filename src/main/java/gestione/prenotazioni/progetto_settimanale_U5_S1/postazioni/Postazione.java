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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Postazione")

public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postazione_id;

    @Column(nullable = false, length = 100)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipoPostazione;

    private int numeroMassimoOccupanti;

    private Edificio edificio;

    private List<Prenotazione> prenotazioni;


}