package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.data.jpa.domain.Prof;

import java.util.Collection;

@Repository
public interface ProfDao extends JpaRepository<Prof,Long> {
    Collection<Prof> findAllByMatiere(String matiere);

}
