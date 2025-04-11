package gestione.prenotazioni.progetto_settimanale_U5_S1.edifici;


import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    boolean existsByIndirizzoAndCitta(String indirizzo, String citta);
}