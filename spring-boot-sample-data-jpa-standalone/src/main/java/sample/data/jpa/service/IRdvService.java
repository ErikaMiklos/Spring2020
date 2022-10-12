package sample.data.jpa.service;

import sample.data.jpa.domain.RDV;
import sample.data.jpa.domain.StatusRdv;

import java.util.Collection;

public interface IRdvService {
    RDV saveRdv(Long profId, String dateRdv, String heureRdv);
    Collection<RDV> getAllRdvs();
    Collection<RDV> getAllRdvsByStatus(StatusRdv statusRdv);
    Collection<RDV> getAllRdvsByProf(Long profId);
    Collection<RDV> getAllRdvsByEtudiant(Long etudiantId);
    RDV getRdvById(Long id);
    RDV updateRdv(Long etudiantId, Long rdvId, StatusRdv statusRdv);
    void deleteRdv(Long id);
}
