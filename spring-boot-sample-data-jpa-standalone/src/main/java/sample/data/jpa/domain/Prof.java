package sample.data.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@DiscriminatorValue("PROF")
public class Prof extends Personne{
    @Column(length = 45, nullable = false)
    private String matiere;
    @OneToMany(mappedBy = "prof")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<RDV> rdvs;
}
