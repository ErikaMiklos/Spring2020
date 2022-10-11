package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RDV {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateRdv;
    @Column(length = 20)
    private String heureRdv;
    @Enumerated(EnumType.STRING)
    private StatusRdv statusRdv;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Etudiant etudiant;
    private String etudiantNom;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Prof prof;
    private String profNom;

}
