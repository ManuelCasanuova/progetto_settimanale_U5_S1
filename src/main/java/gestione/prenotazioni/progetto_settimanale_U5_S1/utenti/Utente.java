package gestione.prenotazioni.progetto_settimanale_U5_S1.utenti;

import gestione.prenotazioni.progetto_settimanale_U5_S1.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "utenti")

public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long utente_id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String nomeECognome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente( String nomeECognome,String username, String email) {
        this.nomeECognome = nomeECognome;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n" + "Id: " + utente_id + "\n" +
                "Username: " + username + "\n" +
                "Nominativo: " + nomeECognome  + "\n" +
                "Email: " + email;
    }
}