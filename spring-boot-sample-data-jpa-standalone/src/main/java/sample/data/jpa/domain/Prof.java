package sample.data.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("PROF")
public class Prof extends Personne{
    @Column(length = 45)
    private String Matiere;
    @OneToMany(mappedBy = "prof")
    private Collection<RDV> rdvs;
}
