package gestione.prenotazioni.progetto_settimanale_U5_S1.edifici;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "edifici")

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long edificio_id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String indirizzo;

    @Column(nullable = false, length = 100)
    private String città;


}