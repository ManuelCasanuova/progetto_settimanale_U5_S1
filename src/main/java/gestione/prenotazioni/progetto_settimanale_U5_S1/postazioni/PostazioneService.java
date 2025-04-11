package gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void savePostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
        System.out.println("Postazione " + postazione.getDescrizione() + " salvata con successo!");
    }

    public List<Postazione> getAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public List <Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta){
        List<Postazione> postazioni = postazioneRepository.findByTipoAndCitta(tipo, citta);
        return postazioni;
    }

    public void saveAllPostazioni(List<Postazione> postazioni) {
        postazioneRepository.saveAll(postazioni);
    }
}
