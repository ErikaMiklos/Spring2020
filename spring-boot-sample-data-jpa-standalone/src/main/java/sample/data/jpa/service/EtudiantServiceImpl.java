package sample.data.jpa.service;

import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.repository.EtudiantDao;

import java.util.Collection;
@Service
public class EtudiantServiceImpl implements IEtudiantService{
    private final EtudiantDao etudiantDao;

    public EtudiantServiceImpl(EtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    @Override
    public Collection<Etudiant> getAllEtudiants() {
        return etudiantDao.findAll();
    }

    @Override
    public Collection<Etudiant> getAllEtudiantsByFaculte(String faculte) {
        return etudiantDao.findAllByFaculte(faculte);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", id)
        );
    }

    @Override
    public Etudiant updateEtudiant(Long id, Etudiant etudiant) {
        Etudiant etudiant1 = etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", id)
        );
        etudiant1.setNom(etudiant.getNom());
        etudiant1.setPrenom(etudiant.getPrenom());
        etudiant1.setFaculte(etudiant.getFaculte());

        return etudiantDao.save(etudiant1);
    }

    @Override
    public void deleteEtudiant(Long id) {
        Etudiant etudiant = etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", id)
        );
        etudiantDao.delete(etudiant);
    }
}
