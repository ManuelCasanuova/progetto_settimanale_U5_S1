package gestione.prenotazioni.progetto_settimanale_U5_S1.edifici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void saveEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
        System.out.println("Edificio" + edificio .getNome() + " salvato con successo");
    }

    public List<Edificio> getAllEdifici() {
        return edificioRepository.findAll();
    }

    public void saveAllEdifici(List<Edificio> edifici) {
        edificioRepository.saveAll(edifici);
    }
}
