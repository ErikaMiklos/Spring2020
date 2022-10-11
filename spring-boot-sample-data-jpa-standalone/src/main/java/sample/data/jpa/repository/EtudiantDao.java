package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.data.jpa.domain.Etudiant;

import java.util.Collection;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Collection<Etudiant> findAllByFaculte(String faculte);
}
