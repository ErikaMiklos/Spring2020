package sample.data.jpa.service;

import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Etudiant;

import javax.transaction.Transactional;
import java.util.Collection;

public interface IEtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    Collection<Etudiant> getAllEtudiants();
    Collection<Etudiant> getAllEtudiantsByFaculte(String faculte);
    Etudiant getEtudiantById(Long id);
    Etudiant updateEtudiant(Long id, Etudiant etudiant);
    void deleteEtudiant(Long id);
}
