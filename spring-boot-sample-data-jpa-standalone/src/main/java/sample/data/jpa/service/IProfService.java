package sample.data.jpa.service;

import sample.data.jpa.domain.Prof;
import java.util.Collection;

public interface IProfService {
    Prof saveProf(Prof prof);
    Collection<Prof> getAllProfs();
    Collection<Prof> getAllProfsByMatiere(String matiere);
    Prof getProfById(Long id);
    Prof updateProf(Long id, Prof prof);
    void deleteProf(Long id);
}
