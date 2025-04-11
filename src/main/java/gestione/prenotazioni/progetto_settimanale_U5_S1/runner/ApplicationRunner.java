package gestione.prenotazioni.progetto_settimanale_U5_S1.runner;

import gestione.prenotazioni.progetto_settimanale_U5_S1.edifici.EdificioService;
import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.ListaVuotaException;
import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.NonTrovatoException;
import gestione.prenotazioni.progetto_settimanale_U5_S1.exceptions.SalvataggioException;
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
        System.out.println(" ");
        System.out.println("*****************************************************************");
        System.out.println("Benvenuto nel menù per la prenotazione delle postazioni aziendali");
        System.out.println("*****************************************************************");
        System.out.println(" ");

        while (true) {
            System.out.println("Ti sei già registrato sulla nostra piattaforma?");
            System.out.println("1. Si");
            System.out.println("2. No");
            System.out.println(" ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            while (scelta != 1 && scelta != 2) {
                System.out.println("Scelta non valida, riprova. Devi selezionare 1 o 2");
                scelta = scanner.nextInt();
                scanner.nextLine();
            }

            Utente utente = null;
            if (scelta == 1) {
                System.out.println("Inserisci il tuo username");
                String username = scanner.nextLine();
                try {
                    utente = utenteService.findUtenteByUsername(username);
                } catch (NonTrovatoException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Lo username inserito non sembra corretto, si prega di riprovare");
                    continue;
                }
            } else {
                System.out.println(" ");
                System.out.println("Procedi con la registrazione, per favore");
                System.out.println(" ");
                System.out.println("Inserisci nome e cognome");
                String nomeECognome = scanner.nextLine();
                System.out.println("Inserisci username");
                String username = scanner.nextLine();
                System.out.println("Inserisci email");
                String email = scanner.nextLine();
                try {
                    utente = utenteService.saveUtente(new Utente(nomeECognome, username, email));
                } catch (SalvataggioException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Lo username inserito non sembra corretto, si prega di riprovare");
                    continue;
                }
            }
            System.out.println(" ");
            System.out.println("Ti diamo il benvenuto " + utente.getNomeECognome());
            System.out.println(" ");

            while (true) {
                System.out.println("Seleziona cosa vuoi fare");
                System.out.println("1. Prenota postazione");
                System.out.println("2. Cancella prenotazione");
                System.out.println("0. Esci");
                int scelta2 = scanner.nextInt();
                scanner.nextLine();

                while (scelta2 != 1 && scelta2 != 2 && scelta2 != 0) {
                    System.out.println("Scelta non valida, riprova. Devi selezionare 1, 2, 3 o 0");
                    scelta2 = scanner.nextInt();
                    scanner.nextLine();
                }

                switch (scelta2) {
                    case 1:
                        prenotaLaPostazione(utente);
                        break;
                    case 2:
                        cancellaLaPrenotazione(utente);
                        break;

                    case 3:
                        ListaPrenotazioniEffettuate(utente);
                        break;
                    case 0:
                        System.out.println("Grazie per aver utilizzato il nostro servizio.");
                        return;
                }
            }
        }
    }


    //--------------Metodo per la cancellazione di una prenotazione


    private void cancellaLaPrenotazione(Utente utente) {
      try{
        System.out.println("Di seguito l'elenco delle prenotazioni effettuate");
        List<Prenotazione> prenotazioni = prenotazioneService.cercaPrenotazionePerUtente(utente);
        prenotazioni.forEach(prenotazione -> System.out.println((prenotazioni.indexOf(prenotazione) + 1) + " - " + prenotazione));
        int scelta = scanner.nextInt();
        scanner.nextLine();

        while (true){
            if(scelta <= 0 || scelta > prenotazioni.size()){
                System.out.println("Scelta non valida, riprova. Devi selezionare un numero tra 1 e " + prenotazioni.size());
                scelta = scanner.nextInt();
                scanner.nextLine();
            } else {
                break;
            }
        }
        System.out.println("Sei davvero sicuro di voler cancellare la prenotazione: " + prenotazioni.get(scelta - 1) + "?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int scelta2 = scanner.nextInt();
        scanner.nextLine();
        while(true){
            if(scelta2 != 1 && scelta2 != 2) System.out.println("Scelta non valida, riprova. Devi selezionare 1 o 2");
            else break;
        }
        if(scelta2 == 1) prenotazioneService.cancellaPrenotazione(prenotazioni.get(scelta - 1));
        else System.out.println("Torna al menu");
    }
    catch (ListaVuotaException e){
        System.out.println("Nessuna prenotazione effettuata");
    }
    }


    //-----------Metodo per la prenotazione della postazione


    private void prenotaLaPostazione(Utente utente) {
        System.out.println("Selezionare il tipo di postazione da prenotare");
        List<TipoPostazione> tipiPostazione = Arrays.stream(TipoPostazione.values()).toList();
        tipiPostazione.forEach(tipoPostazione -> System.out.println((tipiPostazione.indexOf(tipoPostazione) + 1) + " - " + tipoPostazione));
        int sceltaTipoPostazione = scanner.nextInt();
        scanner.nextLine();

        while (sceltaTipoPostazione <= 0 || sceltaTipoPostazione > tipiPostazione.size()) {
            System.out.println("Scelta non valida, riprova. Devi selezionare un numero tra 1 e " + tipiPostazione.size());
            sceltaTipoPostazione = scanner.nextInt();
            scanner.nextLine();
        }

        TipoPostazione tipoPostazione = tipiPostazione.get(sceltaTipoPostazione - 1);

        System.out.println("Inserisci la città dove si vuole prenotare la postazione");
        String citta = scanner.nextLine();

        try {
            List<Postazione> postazioni = postazioneService.findByTipoAndEdificio_Citta(tipoPostazione, citta);
            System.out.println("Di seguito l'elenco delle postazioni, seleziona quella di cui hai bisogno.");
            postazioni.forEach(postazione -> System.out.println((postazioni.indexOf(postazione) + 1) + " - " + postazione));
            int selezione = scanner.nextInt();
            scanner.nextLine();

            while (selezione <= 0 || selezione > postazioni.size()) {
                System.out.println("Scelta non valida, riprova. Devi selezionare un numero tra 1 e " + postazioni.size());
                selezione = scanner.nextInt();
                scanner.nextLine();
            }

            Postazione postazione = postazioni.get(selezione - 1);

            LocalDate date;
            System.out.println("Inserisci la data in cui vorresti prenotare la postazione (YYYY-MM-DD)");
            while (true) {
                try {
                    date = LocalDate.parse(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Formato data non valido, riprova");
                }
            }

            System.out.println("Inserire il numero di partecipanti");
            int numeroPartecipanti = scanner.nextInt();
            scanner.nextLine();

            if (numeroPartecipanti <= 0) {
                System.out.println("Il numero di partecipanti deve essere maggiore di zero");
                return;
            }

            Prenotazione prenotazione = new Prenotazione();
            prenotazione.setDataPrenotazione(date);
            prenotazione.setPostazione(postazione);
            prenotazione.setUtente(utente);
            prenotazione.setNumeroPartecipanti(numeroPartecipanti);
            prenotazioneService.savePrenotazione(prenotazione);
            System.out.println("Prenotazione effettuata con successo!");

        } catch (NonTrovatoException e) {
            System.out.println(e.getMessage());
            System.out.println("Non è stato possibile trovare alcuna postazione, riprova");
        } catch (SalvataggioException e) {
            System.out.println(e.getMessage());
            System.out.println("Non è stato possibile salvare la prenotazione, riprova");
        }
    }

    private void ListaPrenotazioniEffettuate( Utente  utente){
        try {
            prenotazioneService.cercaPrenotazionePerUtente(utente).forEach(System.out::println);
        } catch (ListaVuotaException e) {
            System.out.println("La lista delle prenotazioni è vuota");
        }
    }
}