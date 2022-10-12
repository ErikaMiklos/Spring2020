package sample.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.domain.StatusRdv;

import java.util.Collection;

@Repository
public interface RdvDao extends JpaRepository<RDV, Long> {
    Collection<RDV> findAllByStatusRdv(StatusRdv statusRdv);
}
