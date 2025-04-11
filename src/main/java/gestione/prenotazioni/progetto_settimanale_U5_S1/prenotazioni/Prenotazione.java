package gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni;

import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.Postazione;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "prenotazioni")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long prenotazione_id;

    @Column(nullable = false)
    private LocalDate  dataPrenotazione;

    private int numeroPartecipanti;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Prenotazione(LocalDate dataPrenotazione, Postazione postazione, Utente utente) {
        this.dataPrenotazione = dataPrenotazione;
        this.postazione = postazione;
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "\n" +
                "Data prenotazione: " + dataPrenotazione + "\n" +
                "Numero dei partecipanti: " + (numeroPartecipanti!=0 ? numeroPartecipanti: "N/A") + "\n" +
                "Postazione: " + postazione + "\n" +
                "Utente: " + utente + "\n" +
                "Id prenotazione: " + prenotazione_id + "\n";
    }
}