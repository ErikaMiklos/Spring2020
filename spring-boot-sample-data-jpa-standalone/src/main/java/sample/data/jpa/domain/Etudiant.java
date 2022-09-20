package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("ETUD")
public class Etudiant extends Personne{
    private String faculte;
    @OneToMany(mappedBy = "etudiant")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<RDV> rdvs;
}
