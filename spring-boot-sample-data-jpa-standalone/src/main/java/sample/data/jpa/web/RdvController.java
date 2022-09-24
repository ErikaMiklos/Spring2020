package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.service.EtudiantDao;
import sample.data.jpa.service.ProfDao;
import sample.data.jpa.service.RdvDao;

import java.util.List;

@RestController
@RequestMapping("/rdvs")
public class RdvController {
    @Autowired
    private RdvDao rdvDao;
    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private ProfDao profDao;

    /**
     * POST /create  --> Create a new rdv and save it in the database
     * having the passed id of an existent student.
     */
    @PostMapping("/{etudiantId}")
    public RDV create(@PathVariable Long etudiantId, Long profId, String heureRdv) {

        Etudiant etudiant = etudiantDao.findById(etudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", etudiantId)
        );
        Prof prof = profDao.findById(profId).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", profId)
        );

        RDV rdv = new RDV();
        rdv.setEtudiant(etudiant);
        rdv.setProf(prof);
        rdv.setHeureRdv(heureRdv);
        return rdvDao.save(rdv);
    }

    /**
     * GET /*  --> Return the list of rdvs.
     */
    @GetMapping
    public List<RDV> getRdvs() {
        return rdvDao.findAll();
    }

    /**
     * DELETE /delete  --> Delete the rdv having the passed id.
     */
    @DeleteMapping("/{rdvId}")
    public void delete(@PathVariable long rdvId) {
        RDV rdv = rdvDao.findById(rdvId).orElseThrow(
                () -> new ResourceNotFoundException("RDV", "id", rdvId)
        );
        rdvDao.delete(rdv);
    }

    /**
     * PUT /update  --> Update timetable of the rdv in the
     * database having the passed id.
     */
    @PutMapping(path = "/{rdvId}")
    public RDV updateRDV(@PathVariable long rdvId, String heureRdv) {
        RDV rdv = rdvDao.findById(rdvId).orElseThrow(
                () -> new ResourceNotFoundException("Rdv", "id", rdvId)
        );
        rdv.setHeureRdv(heureRdv);
        return rdvDao.save(rdv);
    }

    /**
     *  GET /get-all-by-prof  --> Return the list of rdvs of an existing prof.
     */
    @GetMapping(path = "/{profId}")
    public List<RDV> getAllByProf(@PathVariable(name = "profId") Long id) {
        Prof prof = profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "profId", id)
        );
        return prof.getRdvs();
    }

/*    *//**
     *  GET /get-all-by-student  --> Return the list of rdvs of an existing student.
     *//*
    @GetMapping(path = "/{etudId}")
    public List<RDV> getAllByEtudiant(@PathVariable(name = "etudId") Long id) {
        Etudiant etudiant = etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "etudId", id)
        );
        return etudiant.getRdvs();
    }*/
}
