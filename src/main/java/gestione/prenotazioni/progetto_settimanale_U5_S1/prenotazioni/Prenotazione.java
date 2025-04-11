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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Prenotazione")

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long prenotazione_id;

    private LocalDate  dataPrenotazione;

    private int numeroPartecipanti;

    private Postazione postazione;

    private Utente utente;




}