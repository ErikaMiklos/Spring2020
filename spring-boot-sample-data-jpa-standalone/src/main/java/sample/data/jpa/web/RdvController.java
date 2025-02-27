package sample.data.jpa.web;

import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.domain.StatusRdv;
import sample.data.jpa.service.IRdvService;

import java.util.Collection;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    private final IRdvService rdvService;

    public RdvController(IRdvService rdvService) {
        this.rdvService = rdvService;
    }

    /**
     * POST /create  --> Create a new rdv with a status open(Ouvert)
     * by an existing prof having the passed id and save it in the database.
     */
    @PostMapping("/{profId}")
    public RDV create(@PathVariable(name = "profId") Long profId,
                      @RequestParam String dateRdv,
                      @RequestParam String heureRdv) {

        return rdvService.saveRdv(profId, dateRdv, heureRdv);
    }

    /**
     * GET /*  --> Return the list of rdvs.
     */
    @GetMapping
    public Collection<RDV> getRdvs() {
        return rdvService.getAllRdvs();
    }

    /**
     * DELETE /delete  --> Delete the rdv having the passed id.
     */
    @DeleteMapping("/{rdvId}")
    public void delete(@PathVariable Long rdvId) {
        rdvService.deleteRdv(rdvId);
    }

    /**
     * PUT /update  --> Update the status (Reserver/Annuler) of a chosen rdv in the
     * database by an existing etudiant and by the id of the related rdv.
     */
    @PutMapping(path = "/{etudiantId}/{rdvId}")
    public RDV updateRDV(@PathVariable Long etudiantId,
                         @PathVariable Long rdvId,
                         @RequestParam StatusRdv statusRdv) {

        return rdvService.updateRdv(etudiantId, rdvId, statusRdv);
    }

    /**
     *  GET /get-all-by-prof  --> Return the list of rdvs of an existing prof.
     */
    @GetMapping(path = "/prof/{profId}")
    public Collection<RDV> getAllByProf(@PathVariable(name = "profId") Long id) {
        return rdvService.getAllRdvsByProf(id);
    }

    /**
     *  GET /get-all-by-student  --> Return the list of rdvs of an existing student.
     */
    @GetMapping(path = "/etudiant/{etudiantId}")
    public Collection<RDV> getAllByEtudiant(@PathVariable(name = "etudiantId") Long id) {
        return rdvService.getAllRdvsByEtudiant(id);
    }

    /**
     *  GET /get-all-by-status  --> Return the list of rdvs by status.
     */
    @GetMapping(path = "/by/{status}")
    public Collection<RDV> getAllByStatus(@PathVariable(name = "status") StatusRdv statusRdv) {
        return rdvService.getAllRdvsByStatus(statusRdv);
    }

    /**
     *  GET /get-by-id  --> Return the rdv found by its id.
     */
    @GetMapping(path = "/{id}")
    public RDV getRdvById(@PathVariable(name = "id") Long id) {
        return rdvService.getRdvById(id);
    }
}
