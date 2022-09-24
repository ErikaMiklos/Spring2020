package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Etudiant;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.service.EtudiantDao;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantDao etudiantDao;

    /**
     * POST /create  --> Create a new etudiant and save it in the database.
     */
    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    /**
     * DELETE /delete  --> Delete the etudiant having the passed id.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Etudiant etudiant = etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", id)
        );
        etudiantDao.delete(etudiant);
    }

    /**
     * GET /*  --> Return the list of etudiants.
     */
    @GetMapping
    public List<Etudiant> getEtudiants() {
        return etudiantDao.findAll();
    }

    /**
     * GET /get-etudiants-by-faculte  --> Return the list of etudiants having its faculte passed.
     */
    @GetMapping(path = "/{faculte}")
    public List<Etudiant> getByFaculte(@PathVariable(name = "faculte") String faculte) {
        return etudiantDao.findAllByFaculte(faculte);
    }

    /**
     * PUT /update  --> Update the name and the firstname for the etudiant in the
     * database having the passed id.
     */
    @PutMapping(path = "/{id}")
    public Etudiant updateEtudiant(@PathVariable long id, @RequestBody Etudiant etudiant) {
        Etudiant etudiant1 = etudiantDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Etudiant", "id", id)
        );
        etudiant1.setNom(etudiant.getNom());
        etudiant1.setPrenom(etudiant.getPrenom());
        etudiant1.setFaculte(etudiant.getFaculte());

        return etudiantDao.save(etudiant1);
    }
}
