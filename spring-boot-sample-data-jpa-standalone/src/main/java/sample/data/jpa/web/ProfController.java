package sample.data.jpa.web;

import org.springframework.web.bind.annotation.*;
import sample.data.jpa.domain.Prof;
import sample.data.jpa.service.IProfService;

import java.util.Collection;

@RestController
@RequestMapping("/profs")
public class ProfController {
    private final IProfService profService;

    public ProfController(IProfService profService) {
        this.profService = profService;
    }

    /**
     * POST /create  --> Create a new prof and save it in the database.
     */
    @PostMapping
    public Prof create(@RequestBody Prof prof) {
        return profService.saveProf(prof);
    }

    /**
     * DELETE /delete  --> Delete the prof having the passed id.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        profService.deleteProf(id);
    }

    /**
     * GET /*  --> Return the list of profs.
     */
    @GetMapping
    public Collection<Prof> getProfs() {
        return profService.getAllProfs();
    }

    /**
     * GET /*  --> Return the prof having the passed id.
     */
    @GetMapping("/{id}")
    public Prof getProfById(@PathVariable long id) {
        return profService.getProfById(id);
    }

    /**
     * GET /get-by-matiere  --> Return list of profs having the passed matiere.
     */
    @GetMapping(path = "/by/{matiere}")
    public Collection<Prof> getByMatiere(@PathVariable String matiere) {
        return profService.getAllProfsByMatiere(matiere);
    }


    /**
     * PUT /update  --> Update the name and the firstname for the prof in the
     * database having the passed id.
     */
    @PutMapping(path = "/{id}")
    public Prof updateProf(@PathVariable Long id, @RequestBody Prof prof) {
        return profService.updateProf(id, prof);
    }
}
