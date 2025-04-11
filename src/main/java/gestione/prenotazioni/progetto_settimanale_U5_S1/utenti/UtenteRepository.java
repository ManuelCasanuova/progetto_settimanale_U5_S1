package gestione.prenotazioni.progetto_settimanale_U5_S1.utenti;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    Utente findByUsername(String username);
}