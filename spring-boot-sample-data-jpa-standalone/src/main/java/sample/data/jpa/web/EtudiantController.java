package sample.data.jpa.web;

import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.service.IEtudiantService;

import java.util.Collection;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    private final IEtudiantService etudiantService;

    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /**
     * POST /create  --> Create a new etudiant and save it in the database.
     */
    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    /**
     * DELETE /delete  --> Delete the etudiant having the passed id.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    /**
     * GET /*  --> Return the list of etudiants.
     */
    @GetMapping
    public Collection<Etudiant> getEtudiants() {

        return etudiantService.getAllEtudiants();
    }

    /**
     * GET /get-etudiants-by-faculte  --> Return the list of etudiants having its faculte passed.
     */
    @GetMapping(path = "/{faculte}")
    public Collection<Etudiant> getByFaculte(@PathVariable String faculte) {
        return etudiantService.getAllEtudiantsByFaculte(faculte);
    }

    /**
     * PUT /update  --> Update the name and the firstname for the etudiant in the
     * database having the passed id.
     */
    @PutMapping(path = "/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id,
                                   @RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(id, etudiant);
    }
}
