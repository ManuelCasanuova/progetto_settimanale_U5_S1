package gestione.prenotazioni.progetto_settimanale_U5_S1.utenti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Utente")

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


}