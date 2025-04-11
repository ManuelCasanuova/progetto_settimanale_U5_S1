package gestione.prenotazioni.progetto_settimanale_U5_S1.runner;

import gestione.prenotazioni.progetto_settimanale_U5_S1.edifici.EdificioService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.postazioni.PostazioneService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni.PrenotazioneService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.Utente;
import gestione.prenotazioni.progetto_settimanale_U5_S1.utenti.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(2)
public class ApplicationRunner implements CommandLineRunner {


    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private Scanner scanner;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("*****************************************************************");
        System.out.println("Benvenuto nel menù per la prenotazione delle postazioni aziendali");
        System.out.println("*****************************************************************");

        while(true){
            System.out.println("Sei un utente registrato?");
            System.out.println("1. Si");
            System.out.println("2. No");
            int scelta = scanner.nextInt();
            while(true) {
                if (scelta != 1 && scelta != 2) {
                    System.out.println("Scelta non valida, riprova. Devi selezionare 1 o 2");
                } else break;
            }
                Utente utente = null;
                if(scelta == 1){
                    System.out.println("Inserisci username");
                    String username = scanner.nextLine();
                    utente=utenteService.findUtenteByUsername(username);
                }

                if(scelta == 2) {
                    System.out.println("Procedi con la registrazione, per favore");
                    System.out.println("Inserisci nome e cognome");
                    String nomeECognome = scanner.nextLine();
                    System.out.println("Inserisci username");
                    String username = scanner.nextLine();
                    System.out.println("Inserisci email");
                    String email = scanner.nextLine();
                    utenteService.saveUtente(new Utente(nomeECognome, username, email));
                }
                utente=utenteService.findUtenteByUsername(utente.getUsername());
            }
        System.out.println("Ti diamo il benvenuto " + utente.getNomeECognome());
        while(true){
            System.out.println("Seleziona cosa vuoi fare");
            System.out.println("1. Prenota postazione");
            System.out.println("2. Cancella prenotazione");
            System.out.println("0. Esci");
        }


    }
}
