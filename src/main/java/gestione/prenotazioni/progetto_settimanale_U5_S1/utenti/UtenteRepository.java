package gestione.prenotazioni.progetto_settimanale_U5_S1.utenti;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    boolean existsByEmailOrUsername(String email, String username);
    Utente findFirstByUsername(String username);


}