package sample.data.jpa.web;

import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.service.ProfDao;

import java.util.Collection;

@RestController
@RequestMapping("/profs")
public class ProfController {
    private final ProfDao profDao;
    public ProfController(ProfDao profDao) {
        this.profDao = profDao;
    }

    /**
     * POST /create  --> Create a new prof and save it in the database.
     */
    @PostMapping
    public Prof create(@RequestBody Prof prof) {
        return profDao.save(prof);
    }

    /**
     * DELETE /delete  --> Delete the prof having the passed id.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Prof prof1 = profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", id)
        );
        profDao.delete(prof1);
    }

    /**
     * GET /*  --> Return the list of profs.
     */
    @GetMapping
    public Collection<Prof> getProfs() {
        return profDao.findAll();
    }

    /**
     * GET /get-by-matiere  --> Return the id for prof having the passed matiere.
     */
    @GetMapping(path = "/{matiere}")
    public Long getByMatiere(@PathVariable String matiere) {
        Prof prof = profDao.findByMatiere(matiere).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "matiere", matiere)
        );
        return prof.getId();
    }


    /**
     * PUT /update  --> Update the name and the firstname for the prof in the
     * database having the passed id.
     */
    @PutMapping(path = "/{id}")
    public Prof updateProf(@PathVariable Long id, @RequestBody Prof prof) {
        Prof prof1 = profDao.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Prof", "id", id)
        );
        prof1.setNom(prof.getNom());
        prof1.setPrenom(prof.getPrenom());

        return profDao.save(prof1);
    }
}
