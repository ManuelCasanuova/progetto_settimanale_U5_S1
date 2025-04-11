package gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipo AND p.edificio.citta= :citta")
    List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta);
}