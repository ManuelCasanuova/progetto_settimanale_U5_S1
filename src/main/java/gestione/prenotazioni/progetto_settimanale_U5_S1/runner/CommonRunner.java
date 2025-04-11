package gestione.prenotazioni.progetto_settimanale_U5_S1.runner;

import gestione.prenotazioni.progetto_settimanale_U5_S1.edifici.Edificio;
import gestione.prenotazioni.progetto_settimanale_U5_S1.edifici.EdificioService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.Postazione;
import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.PostazioneService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.TipoPostazione;
import gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni.Prenotazione;
import gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni.PrenotazioneService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.Utente;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
public class CommonRunner implements CommandLineRunner {


    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

        //--------------------------EDIFICI-------------------------------------

        Edificio edificio1 = new Edificio();
        edificio1.setNome("Edificio 1");
        edificio1.setIndirizzo("Via Roma 1");
        edificio1.setCitta("Milano");

        Edificio edificio2 = new Edificio();
        edificio2.setNome("Edificio 2");
        edificio2.setIndirizzo("Via Milano 2");
        edificio2.setCitta("Roma");

        Edificio edificio3 = new Edificio();
        edificio3.setNome("Edificio 3");
        edificio3.setIndirizzo("Via Napoli 3");
        edificio3.setCitta("Napoli");

        Edificio edificio4 = new Edificio();
        edificio4.setNome("Edificio 4");
        edificio4.setIndirizzo("Via Firenze 4");
        edificio4.setCitta("Torino");

        Edificio edificio5 = new Edificio();
        edificio5.setNome("Edificio 5");
        edificio5.setIndirizzo("Via Bologna 5");
        edificio5.setCitta("Bologna");

        List<Edificio> edifici = Arrays.asList(edificio1, edificio2, edificio3, edificio4, edificio5);
        edificioService.saveAllEdifici(edifici);

        //----------------------POSTAZIONI---------------------------------------------


        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Postazione 1");
        postazione1.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione1.setNumeroMassimoOccupanti(30);
        postazione1.setEdificio(edificio1);

        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Postazione 2");
        postazione2.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione2.setNumeroMassimoOccupanti(5);
        postazione2.setEdificio(edificio2);

        Postazione postazione3 = new Postazione();
        postazione3.setDescrizione("Postazione 3");
        postazione3.setTipoPostazione(TipoPostazione.SALA_RIUNINONI);
        postazione3.setNumeroMassimoOccupanti(15);
        postazione3.setEdificio(edificio3);


        Postazione postazione4 = new Postazione();
        postazione4.setDescrizione("Postazione 4");
        postazione4.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione4.setNumeroMassimoOccupanti(8);
        postazione4.setEdificio(edificio4);

        Postazione postazione5 = new Postazione();
        postazione5.setDescrizione("Postazione 5");
        postazione5.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione5.setNumeroMassimoOccupanti(28);
        postazione5.setEdificio(edificio5);

        List<Postazione> postazioni = Arrays.asList(postazione1, postazione2, postazione3, postazione4, postazione5);
        postazioneService.saveAllPostazioni(postazioni);


        //---------------------UTENTI---------------------------

        Utente utente1 = new Utente();
        utente1.setUsername("utente1");
        utente1.setNomeECognome("Dario Lampa");
        utente1.setEmail("dario.lampa@example.com");


        Utente utente2 = new Utente();
        utente2.setUsername("utente2");
        utente2.setNomeECognome("Erno Padre");
        utente2.setEmail("erno.padre@example.com");

        Utente utente3 = new Utente();
        utente3.setUsername("utente3");
        utente3.setNomeECognome("Gina Cande");
        utente3.setEmail("gina.cande@example.com");

        Utente utente4 = new Utente();
        utente4.setUsername("utente4");
        utente4.setNomeECognome("Lena Alta");
        utente4.setEmail("lena.alta@example.com");

        Utente utente5 = new Utente();
        utente5.setUsername("utente5");
        utente5.setNomeECognome("Tina Schiaccia");
        utente5.setEmail("tina.schiaccia@example.com");

        List<Utente> utenti = Arrays.asList(utente1, utente2, utente3, utente4, utente5);
        utenteService.saveAllUtenti(utenti);

        //---------------------PRENOTAZIONI---------------------------

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setDataPrenotazione(LocalDate.now());
        prenotazione1.setNumeroPartecipanti(5);
        prenotazione1.setPostazione(postazione2);
        prenotazione1.setUtente(utente1);

        Prenotazione  prenotazione2 = new Prenotazione();
        prenotazione2.setDataPrenotazione(LocalDate.of(2024,04, 12));
        prenotazione2.setNumeroPartecipanti(1);
        prenotazione2.setPostazione(postazione1);
        prenotazione2.setUtente(utente3);

        Prenotazione  prenotazione3 = new Prenotazione();
        prenotazione3.setDataPrenotazione(LocalDate.of(2024, 04, 11));
        prenotazione3.setNumeroPartecipanti(2);
        prenotazione3.setPostazione(postazione4);
        prenotazione3.setUtente(utente5);

        Prenotazione  prenotazione4 = new Prenotazione();
        prenotazione4.setDataPrenotazione(LocalDate.of(2024, 04, 13));
        prenotazione4.setNumeroPartecipanti(26);
        prenotazione4.setPostazione(postazione5);
        prenotazione4.setUtente(utente2);

        List<Prenotazione> prenotazioni = Arrays.asList(prenotazione1, prenotazione2, prenotazione3, prenotazione4);
        prenotazioneService.saveAllPrenotazioni(prenotazioni);



    }
}
