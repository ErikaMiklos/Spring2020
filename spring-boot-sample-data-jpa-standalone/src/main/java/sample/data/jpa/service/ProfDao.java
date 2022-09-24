package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sample.data.jpa.domain.Prof;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public interface ProfDao extends JpaRepository<Prof,Long> {
    Optional<Prof> findByMatiere(String matiere);

}
