package sample.data.jpa.service;

import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.repository.ProfDao;

import java.util.Collection;
@Service
public class ProfServiceImpl implements IProfService{
    private ProfDao profDao;

    public ProfServiceImpl(ProfDao profDao) {
        this.profDao = profDao;
    }

    @Override
    public Prof saveProf(Prof prof) {
        return profDao.save(prof);
    }

    @Override
    public Collection<Prof> getAllProfs() {
        return profDao.findAll();
    }

    @Override
    public Collection<Prof> getAllProfsByMatiere(String matiere) {
        return profDao.findAllByMatiere(matiere);
    }

    @Override
    public Prof getProfById(Long id) {
        return profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", id)
        );
    }

    @Override
    public Prof updateProf(Long id, Prof prof) {
        Prof prof1 = profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", id)
        );
        prof1.setNom(prof.getNom());
        prof1.setPrenom(prof.getPrenom());
        prof1.setMatiere(prof.getMatiere());

        return profDao.save(prof1);
    }

    @Override
    public void deleteProf(Long id) {
        Prof prof = profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", id)
        );
        profDao.delete(prof);
    }
}
