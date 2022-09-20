package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("PROF")
public class Prof extends Personne{
    @Column(length = 45)
    private String matiere;
    @OneToMany(mappedBy = "prof")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Collection<RDV> rdvs;
}
