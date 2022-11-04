package sample.data.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "TYPE", length = 4)
public abstract class Personne {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 45)
    private String nom;
    @Column(length = 45)
    private String prenom;
}
