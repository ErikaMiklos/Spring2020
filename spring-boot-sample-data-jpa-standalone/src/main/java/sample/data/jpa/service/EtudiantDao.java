package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Etudiant;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByFaculte(String faculte);
}
