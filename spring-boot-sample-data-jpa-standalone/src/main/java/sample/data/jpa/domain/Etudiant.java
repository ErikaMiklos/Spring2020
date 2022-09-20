package sample.data.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("ETUD")
public class Etudiant extends Personne{
    private double note;
    @OneToMany(mappedBy = "etudiant")
    private Collection<RDV> rdvs;
}
