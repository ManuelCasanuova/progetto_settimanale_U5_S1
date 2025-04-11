package gestione.prenotazioni.progetto_settimanale_U5_S1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class BeansConfig {

    @Bean
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
