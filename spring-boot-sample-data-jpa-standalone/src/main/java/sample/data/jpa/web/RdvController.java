package sample.data.jpa.web;

import com.fasterxml.jackson.annotation.JsonProperty;
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
     * POST /create  --> Create a new rdv and save it in the database.
     */
    @PostMapping
    public RDV create(Long profId, Long etudiantId, String heureDebut, String heureFin) {
        Prof prof = profDao.findById(profId).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", profId)
        );
        Etudiant etudiant = etudiantDao.findById(etudiantId).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", etudiantId)
        );
        RDV rdv = new RDV();
        rdv.setHeureDebut(heureDebut);
        rdv.setHeureFin(heureFin);
        rdv.setEtudiant(etudiant);
        rdv.setProf(prof);
        rdv.setReserve(true);
        return rdvDao.save(rdv);
    }


}
