package sample.data.jpa.service;

import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.domain.StatusRdv;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.repository.EtudiantDao;
import sample.data.jpa.repository.ProfDao;
import sample.data.jpa.repository.RdvDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Service
public class RdvServiceImpl implements IRdvService{
    private final RdvDao rdvDao;
    private final ProfDao profDao;
    private final EtudiantDao etudiantDao;

    public RdvServiceImpl(RdvDao rdvDao, ProfDao profDao, EtudiantDao etudiantDao) {
        this.rdvDao = rdvDao;
        this.profDao = profDao;
        this.etudiantDao = etudiantDao;
    }

    @Override
    public RDV saveRdv(Long profId, String dateRdv, String heureRdv) {
        Prof prof = profDao.findById(profId).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", profId)
        );

        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateRdv);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RDV rdv = new RDV();
        rdv.setProf(prof);
        rdv.setProfNom(prof.getNom());
        rdv.setDateRdv(date);
        rdv.setHeureRdv(heureRdv);
        rdv.setStatusRdv(StatusRdv.OUVERT);
        return rdvDao.save(rdv);
    }

    @Override
    public Collection<RDV> getAllRdvs() {
        return rdvDao.findAll();
    }

    @Override
    public Collection<RDV> getAllRdvsByStatus(StatusRdv statusRdv) {
        return rdvDao.findAllByStatusRdv(statusRdv);
    }

    @Override
    public Collection<RDV> getAllRdvsByProf(Long profId) {
        Prof prof = profDao.findById(profId).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", profId));
        return prof.getRdvs();
    }

    @Override
    public Collection<RDV> getAllRdvsByEtudiant(Long etudiantId) {
        Etudiant etudiant = etudiantDao.findById(etudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", etudiantId));
        return etudiant.getRdvs();
    }

    @Override
    public RDV getRdvById(Long id) {
        return rdvDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("RDV", "id", id)
        );
    }

    @Override
    public RDV updateRdv(Long etudiantId, Long rdvId, StatusRdv statusRdv) {
        Etudiant etudiant = etudiantDao.findById(etudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", etudiantId)
        );

        RDV rdv = rdvDao.findById(rdvId).orElseThrow(
                () -> new ResourceNotFoundException("Rdv", "id", rdvId)
        );

        rdv.setEtudiant(etudiant);
        rdv.setEtudiantNom(etudiant.getNom());
        rdv.setStatusRdv(statusRdv);
        return rdvDao.save(rdv);
    }

    @Override
    public void deleteRdv(Long id) {
        RDV rdv = rdvDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("RDV", "id", id)
        );

        rdvDao.delete(rdv);
    }
}
