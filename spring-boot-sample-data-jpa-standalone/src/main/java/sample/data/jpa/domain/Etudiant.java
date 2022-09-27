package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("ETUD")
public class Etudiant extends Personne{
    private String faculte;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<RDV> rdvs;
}
