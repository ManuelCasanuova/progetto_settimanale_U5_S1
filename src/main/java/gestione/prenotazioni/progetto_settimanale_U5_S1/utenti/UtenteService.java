package gestione.prenotazioni.progetto_settimanale_U5_S1.utenti;

import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.NonTrovatoException;
import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.SalvataggioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente saveUtente(Utente utente) {
        if(utenteRepository.existsByEmail(utente.getEmail() ) || utenteRepository.existsByUsername(utente.getUsername())) throw new SalvataggioException("Utente già esistente, impossibile salvarlo nuovamente.");
        if(utente.getNomeECognome().length() <= 2) throw new SalvataggioException("Il nome e il cognome devono avere almeno 3 caratteri.");
        Utente utenteSalvato = utenteRepository.save(utente);
        System.out.println("Utente salvato con successo: " + utente);
        return utenteSalvato;
    }



    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente findUtenteByUsername(String username) {
        Utente utente = utenteRepository.findByUsername(username);
        if(utente==null) throw new NonTrovatoException("Utente: " + utente + " non trovato.");
        return utente;
    }
}
