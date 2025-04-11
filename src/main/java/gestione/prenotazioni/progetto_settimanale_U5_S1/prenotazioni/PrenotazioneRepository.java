package gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni;


import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.Postazione;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
    boolean existByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
    List<Prenotazione> findByUtente(Utente utente);
}