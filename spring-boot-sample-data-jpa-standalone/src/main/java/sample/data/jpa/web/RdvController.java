package sample.data.jpa.web;

import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.domain.StatusRdv;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.service.EtudiantDao;
import sample.data.jpa.service.ProfDao;
import sample.data.jpa.service.RdvDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    private final RdvDao rdvDao;
    private final EtudiantDao etudiantDao;
    private final ProfDao profDao;

    public RdvController(RdvDao rdvDao, EtudiantDao etudiantDao, ProfDao profDao) {
        this.rdvDao = rdvDao;
        this.etudiantDao = etudiantDao;
        this.profDao = profDao;
    }

    /**
     * POST /create  --> Create a new rdv and save it in the database
     * having the passed id of an existent prof.
     */
    @PostMapping("/{profId}")
    public RDV create(@PathVariable(name = "profId") Long profId,
                      @RequestParam String dateRdv,
                      @RequestParam String heureRdv) {

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

    /**
     * GET /*  --> Return the list of rdvs.
     */
    @GetMapping
    public Collection<RDV> getRdvs() {
        return rdvDao.findAll();
    }

    /**
     * DELETE /delete  --> Delete the rdv having the passed id.
     */
    @DeleteMapping("/{rdvId}")
    public void delete(@PathVariable Long rdvId) {
        RDV rdv = rdvDao.findById(rdvId).orElseThrow(
                () -> new ResourceNotFoundException("RDV", "id", rdvId)
        );

        rdvDao.delete(rdv);
    }

    /**
     * PUT /update  --> Update the status of an existing rdv in the
     * database having the passed etudiant and rdv id.
     */
    @PutMapping(path = "/{etudiantId}/{rdvId}")
    public RDV updateRDV(@PathVariable Long etudiantId,
                         @PathVariable Long rdvId,
                         @RequestParam StatusRdv statusRdv) {
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

    /**
     *  GET /get-all-by-prof  --> Return the list of rdvs of an existing prof.
     */
    @GetMapping(path = "/prof/{profId}")
    public Collection<RDV> getAllByProf(@PathVariable(name = "profId") Long id) {
        Prof prof = profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "profId", id)
        );
        return prof.getRdvs();
    }

    /**
     *  GET /get-all-by-student  --> Return the list of rdvs of an existing student.
     */
    @GetMapping(path = "/etudiant/{etudiantId}")
    public Collection<RDV> getAllByEtudiant(@PathVariable(name = "etudiantId") Long id) {
        Etudiant etudiant = etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "etudiantId", id)
        );
        return etudiant.getRdvs();
    }

    /**
     *  GET /get-all-by-status  --> Return the list of rdvs by status.
     */
    @GetMapping(path = "/by/{status}")
    public Collection<RDV> getAllByStatus(@PathVariable(name = "status") StatusRdv statusRdv) {
        return rdvDao.findAllByStatusRdv(statusRdv);
    }
}
