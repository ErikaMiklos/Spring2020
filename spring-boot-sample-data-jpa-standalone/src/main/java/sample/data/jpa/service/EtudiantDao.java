package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Etudiant;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Collection<Etudiant> findAllByFaculte(String faculte);
}
