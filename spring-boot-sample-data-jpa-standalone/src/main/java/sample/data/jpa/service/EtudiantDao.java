package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.domain.RDV;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Collection<Etudiant> findAllByFaculte(String faculte);
}
