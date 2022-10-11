package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sample.data.jpa.domain.RDV;
import sample.data.jpa.domain.StatusRdv;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public interface RdvDao extends JpaRepository<RDV, Long> {
    Collection<RDV> findAllByStatusRdv(StatusRdv statusRdv);
}
