package gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni;

import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.ListaVuotaException;
import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.SalvataggioException;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void savePrenotazione(Prenotazione prenotazione) {
        if(prenotazioneRepository.existsByPostazioneAndDataPrenotazione(prenotazione.getPostazione(), prenotazione.getDataPrenotazione())) throw new SalvataggioException("Impossibile prenotare la postazione per questa data - la postazione è già prenotata.");
        if(prenotazioneRepository.existByUtenteAndDataPrenotazione(prenotazione.getUtente(), prenotazione.getDataPrenotazione())) throw new SalvataggioException("Impossibile prenotare la postazione per questa data - hai già prenotato per questa data.");
        if(prenotazione.getNumeroPartecipanti() <= 0) throw new SalvataggioException("Il numero di partecipanti deve essere maggiore di zero.");
        if(prenotazione.getNumeroPartecipanti() > prenotazione.getPostazione().getNumeroMassimoOccupanti()) throw new SalvataggioException("Il numero di partecipanti supera il numero massimo di posti della postazione.");
        if(prenotazione.getDataPrenotazione().isBefore(LocalDate.now())) throw new SalvataggioException("La data di prenotazione deve essere successiva alla data odierna.");
        prenotazioneRepository.save(prenotazione);
        System.out.println("Prenotazione: " + prenotazione + " salvata con successo!");
    }

    public List<Prenotazione> trovaTuttePrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public List<Prenotazione> cercaPrenotazionePerUtente(Utente utente) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtente(utente);
        if(prenotazioni.isEmpty()) throw new ListaVuotaException("Nessuna prenotazione trovata per l'utente: " + utente.getUsername());
        return prenotazioni;
    }
}
