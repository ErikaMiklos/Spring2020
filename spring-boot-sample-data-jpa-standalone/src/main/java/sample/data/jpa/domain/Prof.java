package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
//@DiscriminatorValue("PROF")
public class Prof extends Personne{
    private String matiere;
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<RDV> rdvs;
}
