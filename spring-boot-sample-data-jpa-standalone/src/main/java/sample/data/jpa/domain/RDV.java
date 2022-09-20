package sample.data.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RDV {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private StatusRDV status;
    private String heureDebut;
    private String heureFin;
    @ManyToOne
    private Etudiant etudiant;
    @ManyToOne
    private Prof prof;

}
