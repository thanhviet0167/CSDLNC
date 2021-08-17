package api.repository;

import api.domain.SoDiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoDiaChiRepository extends JpaRepository<SoDiaChi, SoDiaChi.SoDiaChiID> {

}
